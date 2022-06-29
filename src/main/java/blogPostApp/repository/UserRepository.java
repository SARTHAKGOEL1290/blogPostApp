package blogPostApp.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import blogPostApp.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
	
	Users findByemail(String username);

	
	
}
