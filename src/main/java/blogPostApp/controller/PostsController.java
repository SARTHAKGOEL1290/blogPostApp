package blogPostApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blogPostApp.dto.PostsDTO;
import blogPostApp.entity.Posts;
import blogPostApp.helper.PostResponse;
import blogPostApp.service.PostsServiceImpel;

@RestController
@RestControllerAdvice
@RequestMapping("/api")
public class PostsController {

	@Autowired
	private PostsServiceImpel postService;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostsDTO> createNewPostController(@RequestBody PostsDTO post,
			                             @PathVariable("userId") Integer userId,
			                             @PathVariable("categoryId") Integer categId)
	{
		System.out.println("HEllo");
		PostsDTO newPost = this.postService.CreatePost(post, userId, categId);
		return new ResponseEntity<PostsDTO>(newPost,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostsDTO>> getPostsByUserController( @PathVariable("userId") Integer userId)
	{
	     List<PostsDTO> postDto = this.postService.getPostByUserId(userId);
	     return new ResponseEntity<List<PostsDTO>>(postDto,HttpStatus.FOUND);
	}
	
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostsDTO>> getPostsByCategoryController( @PathVariable("categoryId") Integer categoryId)
	{
	     List<PostsDTO> postDto = this.postService.getPostByCategoryId(categoryId);
	     return new ResponseEntity<List<PostsDTO>>(postDto,HttpStatus.FOUND);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostsDTO> getPostByIdController(@PathVariable("postId") Integer postId)
	{
		PostsDTO postDto = this.postService.getPostByPostID(postId);
		return new ResponseEntity<PostsDTO>(postDto,HttpStatus.FOUND);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getPostALLController(
			@RequestParam(value="pageNumber",defaultValue ="" ,required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue ="" ,required=false) Integer pageSize
			)
	{
		PostResponse postDto = this.postService.getAllPosts(pageNumber,pageSize);
		return new ResponseEntity<PostResponse>(postDto,HttpStatus.FOUND);
	}
	
	@PutMapping("/posts/update/{postId}")
	public ResponseEntity<PostsDTO> UpdatePostController(@RequestBody PostsDTO post,
            @PathVariable("postId") Integer postId)
	{
		PostsDTO newPost = this.postService.UpdatePost(post, postId);
		return new ResponseEntity<PostsDTO>(newPost,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/posts/delete/{postId}")
	public ResponseEntity<Void> DeletePostController(@PathVariable("postId") Integer postId)
	{
		this.postService.DeletePost(postId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostsDTO>> searchPostByKeywordController(@PathVariable("keyword") String Keyword)
	{
		List<PostsDTO> postDto = this.postService.searchPostsByKeyword(Keyword);
		return new ResponseEntity<List<PostsDTO>>(postDto,HttpStatus.FOUND);
	}
	
	
	
}
