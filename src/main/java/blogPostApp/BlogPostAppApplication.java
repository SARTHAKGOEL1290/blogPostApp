package blogPostApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import blogPostApp.entity.Role;
import blogPostApp.entity.Users;
import blogPostApp.repository.RoleRepository;
import blogPostApp.repository.UserRepository;

@SpringBootApplication
public class BlogPostAppApplication  implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogPostAppApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.passwordEncoder.encode("xyz"));
		
		
		Users user = userRepo.findByemail("sarthakgoel9999@gmail.com");
		System.out.println("==========="+user.getName());
		
		try {
			Role role1 = new Role();
			role1.setId(501);
			role1.setType("NORMAL_USER");
			
			Role role2 = new Role();
			role2.setId(502);
			role2.setType("ADMIN_USER");
			
			List<Role> roles = new ArrayList<>();
			roles.add(role1);
			roles.add(role2);
			
			this.roleRepo.saveAll(roles);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	

}
