package blogPostApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blogPostApp.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
