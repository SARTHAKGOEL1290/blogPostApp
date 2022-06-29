package blogPostApp.dto;

public class CommentDTO {
	
	private int id;
	private String content;
	
	private PostsDTO postDto;
	
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
 
	public CommentDTO(int id, String content, PostsDTO postDto) {
		super();
		this.id = id;
		this.content = content;
		this.postDto = postDto;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public PostsDTO getPostDto() {
		return postDto;
	}



	public void setPostDto(PostsDTO postDto) {
		this.postDto = postDto;
	}
	
	

}
