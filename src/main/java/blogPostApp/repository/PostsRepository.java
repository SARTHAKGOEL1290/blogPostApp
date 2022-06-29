package blogPostApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import blogPostApp.entity.Categories;
import blogPostApp.entity.Posts;
import blogPostApp.entity.Users;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {
	
	//List<Posts> findAllByUsers(Users user);
	//List<Categories> findAllByCategories(Categories category);

	// this is custom finder method provided by JPA inbuilt where ( findBy is same , just need to give varibale name like i give here
	   //findByuser
	List<Posts> findByuser(Users user);
	
	List<Posts> findBycategory(Categories category);
	
	@Query("select p from Posts p where p.title like:Key")
	List<Posts> searchBytitle(@Param("Key") String title);
}
