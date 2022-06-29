package blogPostApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import blogPostApp.dto.UsersDTO;
import blogPostApp.entity.Role;
import blogPostApp.entity.Users;
import blogPostApp.exception.ResourceNotFoundException;
import blogPostApp.repository.RoleRepository;
import blogPostApp.repository.UserRepository;

@Service
public class UsersServiceImpel implements UsersService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<UsersDTO> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> user = userRepo.findAll();
		List<UsersDTO> userDto = user.stream().map(e->this.UserToDto(e)).
				                 collect(Collectors.toList());
		
		return userDto;
	}

	@Override
	public UsersDTO createNewUser(UsersDTO usersDTO) {
		// TODO Auto-generated method stub
		Users user = this.DTOtoUser(usersDTO);
		Users saveduser = this.userRepo.save(user);
		return this.UserToDto(saveduser);
	}

	@Override
	public UsersDTO getUsersByID(Integer userId) {
		// TODO Auto-generated method stub
		
		Users user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
		return this.UserToDto(user);
	}

	@Override
	public void deleteUsers(Integer userId) {
		// TODO Auto-generated method stub
		Users user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId) );
		userRepo.delete(user);
	}

	@Override
	public UsersDTO updateUser(UsersDTO users,Integer id) {
		Users user = userRepo.findById(id).orElseThrow(()->new NullPointerException("this ID does not Exist"));
		
		// updating the email
		user.setEmail(users.getEmail());
		
		Users SavedUser = userRepo.save(user);
		return this.UserToDto(SavedUser);
	}
	
	private Users DTOtoUser(UsersDTO userDto)
	{
		Users user = this.modelmapper.map(userDto, Users.class);
		/*Users user = new Users();
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		*/
		return user;
		
	}
	
	private UsersDTO UserToDto(Users user)
	{
		UsersDTO dto= new UsersDTO();
		
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setAbout(user.getAbout());
		
		return dto;
	}

	@Override
	public UsersDTO CreateNewUser(UsersDTO users) {
		// TODO Auto-generated method stub
		
		System.out.println("------------------------------++++");
		Users user = this.modelmapper.map(users,Users.class);
		
		//set the encoded password
		System.out.println("------------------------------++++"+ this.passwordEncoder.encode(user.getPassword()));
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
	
		
		// fetch the role from role table
		Role role = this.roleRepo.findById(501).get();
		
		// since the getRoles is the list inside so we are using role 
		user.getRoles().add(role);
		
	    Users updatedUser = this.userRepo.save(user);
		
	    return this.modelmapper.map(updatedUser,UsersDTO.class);
	}

}
