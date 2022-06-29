package blogPostApp.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import blogPostApp.entity.Comment;

public class PostsDTO {
	
	private String title;
	private String content;
	private CategoriesDTO category;
	private UsersDTO user;
	
	private Set<CommentDTO> commentDto = new HashSet<CommentDTO>();
	
	public PostsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PostsDTO(String title, String content, CategoriesDTO category, UsersDTO user
			,Set<CommentDTO> commentDto) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.user = user;
		this.commentDto = commentDto;
	}



	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CategoriesDTO getCategory() {
		return category;
	}
	public void setCategory(CategoriesDTO category) {
		this.category = category;
	}
	public UsersDTO getUser() {
		return user;
	}
	public void setUser(UsersDTO user) {
		this.user = user;
	}



	public Set<CommentDTO> getCommentDto() {
		return commentDto;
	}



	public void setCommentDto(Set<CommentDTO> commentDto) {
		this.commentDto = commentDto;
	}


	


	
	
	
	
	

}
