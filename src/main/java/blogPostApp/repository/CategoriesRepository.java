package blogPostApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blogPostApp.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer>{

}
