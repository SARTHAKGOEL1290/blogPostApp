package blogPostApp.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsersDTO {

	private int id;
	
	@NotNull
	@Size(min=2,max=8,message="name is required and of size b/w 2 and 8")
	private String name;
	@Email(message="email is required")
	private String email;
	@NotNull
	@Size(min=2,max=8,message="passwordis required and of size b/w 2 and 8")
	private String password;
	private String about;
	
	private List<PostsDTO> posts = new ArrayList<>();
	
	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UsersDTO(int id,
			@NotNull @Size(min = 2, max = 8, message = "name is required and of size b/w 2 and 8") String name,
			@Email(message = "email is required") String email,
			@NotNull @Size(min = 2, max = 8, message = "passwordis required and of size b/w 2 and 8") String password,
			String about, List<PostsDTO> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.posts = posts;
	}


	/*public UsersDTO(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}


	public List<PostsDTO> getPosts() {
		return posts;
	}


	public void setPosts(List<PostsDTO> posts) {
		this.posts = posts;
	}
	
	
	
}
