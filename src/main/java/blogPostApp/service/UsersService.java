package blogPostApp.service;

import java.util.List;

import blogPostApp.dto.UsersDTO;

public interface UsersService {
	
	UsersDTO CreateNewUser(UsersDTO users);
	
	 List<UsersDTO>getAllUsers();
	 
	 UsersDTO createNewUser(UsersDTO users);
	 
	 UsersDTO getUsersByID(Integer userId);
	 
	 UsersDTO updateUser(UsersDTO users,Integer id);
	 
	 void deleteUsers(Integer userId);
	 

}
