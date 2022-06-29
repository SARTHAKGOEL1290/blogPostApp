package blogPostApp.service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import blogPostApp.dto.PostsDTO;
import blogPostApp.entity.Categories;
import blogPostApp.entity.Posts;
import blogPostApp.entity.Users;
import blogPostApp.exception.ResourceNotFoundException;
import blogPostApp.helper.PostResponse;
import blogPostApp.repository.CategoriesRepository;
import blogPostApp.repository.PostsRepository;
import blogPostApp.repository.UserRepository;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class PostsServiceImpel implements PostsService {

	@Autowired
	private CategoriesRepository categoryRepository;
	@Autowired
	private UserRepository  userRepo;
	@Autowired
	private PostsRepository  postRepo;
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public PostsDTO CreatePost(PostsDTO postDto, Integer UserId, Integer CategoryId) {
		// TODO Auto-generated method stub
		// firstly convert to post using modelmapper
		Posts post = this.modelmapper.map(postDto,Posts.class);
		// firstly fetch the user
		Users user = this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("user","id",UserId));
		// second fetch the category
		Categories category = this.categoryRepository.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("category","id",CategoryId));
		// now set the user and category to post object
		
	    post.setUser(user);
		post.setCategory(category);
		
		Posts savedPost = this.postRepo.save(post);
		
		return this.modelmapper.map(savedPost,PostsDTO.class);
	}

	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
			PageRequest pageable=PageRequest.of(pageNumber,pageSize);
		Page<Posts> pagePosts = this.postRepo.findAll(pageable);
		
		
		
		List<Posts> allpost = pagePosts.getContent(); 
	   
		List<PostsDTO> postsDto =allpost.stream().map((e)->this.modelmapper.map(e,PostsDTO.class)).collect(Collectors.toList());
		PostResponse postsResponse = new PostResponse();
		
		postsResponse.setContent(postsDto);
		postsResponse.setPageNumber(pagePosts.getNumber());
		postsResponse.setPageSize(pagePosts.getSize());
		postsResponse.setTotalPages(pagePosts.getTotalPages());
		postsResponse.setTotalElements(pagePosts.getNumberOfElements());
		postsResponse.setLastPage(pagePosts.isLast());
		
		return postsResponse;
		
	}




	@Override
	public PostsDTO getPostByPostID(Integer postId) {
		// TODO Auto-generated method stub
		
		Posts post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","id",postId));
		
		return this.modelmapper.map(post,PostsDTO.class);
	}

	@Override
	public PostsDTO UpdatePost(PostsDTO post, Integer postId) {
		// TODO Auto-generated method stub
		Posts posts = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","id",postId));
		
		posts.setContent(post.getContent());
		Posts updatedPost = this.postRepo.save(posts);
		return this.modelmapper.map(updatedPost,PostsDTO.class);
	}

	@Override
	public void DeletePost(Integer postId) {
		// TODO Auto-generated method stub
		Posts post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","id",postId));
		
		this.postRepo.delete(post);
	}

	

	@Override
	public List<PostsDTO> getPostByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		Categories categry  = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","id",categoryId));
		// now fetch the Posts according to particular user
		List<Posts> posts = this.postRepo.findBycategory(categry);
		
		List<PostsDTO> postsDto = posts.stream().map((e)-> this.modelmapper.map(e,PostsDTO.class)).collect(Collectors.toList());
		return postsDto;
	}

	@Override
	public List<PostsDTO> getPostByUserId(Integer userId) {
		// TODO Auto-generated method stub
		//firstly fetch the user
		Users user  = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
		// now fetch the Posts according to particular user
		List<Posts> posts = this.postRepo.findByuser(user);
		
		List<PostsDTO> postsDto = posts.stream().map((e)-> this.modelmapper.map(e,PostsDTO.class)).collect(Collectors.toList());
		return postsDto;
	}

	@Override
	public List<PostsDTO> searchPostsByKeyword(String Keyword) {
		// TODO Auto-generated method stub
		List<Posts> listOfPost = this.postRepo.searchBytitle("%"+Keyword+"%");
		List<PostsDTO> postDto = listOfPost.stream().map((post)->this.modelmapper.map(post,PostsDTO.class)).collect(Collectors.toList());
		return postDto;
	}

}
