package blogPostApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import blogPostApp.entity.Users;
import blogPostApp.exception.ResourceNotFoundException;
import blogPostApp.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("-----------)))_)___)_)_)_)_)_)___)))))"+username);
		Users user = this.userRepo.findByemail(username);
				//.orElseThrow(()->new ResourceNotFoundException("user","email:"+username,0));
		return user;
	}
	
	

}
