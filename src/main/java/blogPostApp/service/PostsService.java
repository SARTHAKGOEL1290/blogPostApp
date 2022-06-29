package blogPostApp.service;

import java.util.List;

import blogPostApp.dto.PostsDTO;
import blogPostApp.entity.Posts;
import blogPostApp.helper.PostResponse;

public interface PostsService {
	
	//create new post
    PostsDTO CreatePost(PostsDTO post,Integer UserId,Integer CategoryId);
    // get all post
    PostResponse getAllPosts(Integer pageNumber,Integer pageSize);
    // get post by Id
    PostsDTO getPostByPostID(Integer postId);
    // Update Post
    PostsDTO UpdatePost(PostsDTO post,Integer postId);
    // Delete post
    void DeletePost(Integer postId);
    // get post by User
    List<PostsDTO> getPostByUserId(Integer userId);
    // get post by Category
    List<PostsDTO> getPostByCategoryId(Integer categoryId);
    
    // search post by Keyword
    List<PostsDTO> searchPostsByKeyword(String Keyword);
    
    

}
