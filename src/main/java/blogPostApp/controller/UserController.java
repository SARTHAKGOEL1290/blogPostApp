package blogPostApp.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blogPostApp.dto.UsersDTO;
import blogPostApp.helper.APIResponse;
import blogPostApp.service.UsersServiceImpel;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	public UsersServiceImpel service;
	
	@PostMapping("/add")
	public ResponseEntity<UsersDTO> CreateNewUserContorller(@Valid @RequestBody UsersDTO user)
	{
		UsersDTO addedUser = service.createNewUser(user);
		return new ResponseEntity<UsersDTO>(addedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<UsersDTO>> findAllUserController()
	{
		List<UsersDTO> allUserList = service.getAllUsers();
		return new ResponseEntity<List<UsersDTO>>(allUserList,HttpStatus.FOUND);
	}
	
	@GetMapping("/findById/{UserId}")
	public ResponseEntity<UsersDTO> findUserByIdController(@PathVariable Integer UserId)
	{
		UsersDTO extractedUser = service.getUsersByID(UserId);
		return new ResponseEntity<UsersDTO>(extractedUser,HttpStatus.FOUND);	
	}
	
	@PutMapping("/update/{UserId}")
	public ResponseEntity<UsersDTO> updateUserByController(@Valid @RequestBody UsersDTO user,@PathVariable Integer UserId)
	{
		UsersDTO updatedUser = service.updateUser(user, UserId);
		return new ResponseEntity<UsersDTO>(updatedUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{UserId}")
	public ResponseEntity<APIResponse> deleteByIdController(@PathVariable Integer UserId)
	{
		this.service.deleteUsers(UserId);
	    APIResponse response = new APIResponse("User deleted from DB",true);
	    System.out.println(response.getMessage());
		 return new ResponseEntity<APIResponse>(response,HttpStatus.NO_CONTENT);	
	}
	
	@PostMapping("/register")
	public ResponseEntity<UsersDTO> createNewUserController(@RequestBody UsersDTO users)
	{
		UsersDTO createdUser = this.service.CreateNewUser(users);
		return new ResponseEntity<UsersDTO>(createdUser,HttpStatus.CREATED);
	}

}
