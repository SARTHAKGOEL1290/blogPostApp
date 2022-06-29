package blogPostApp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogPostApp.dto.CommentDTO;
import blogPostApp.entity.Comment;
import blogPostApp.entity.Posts;
import blogPostApp.exception.ResourceNotFoundException;
import blogPostApp.repository.CommentRepository;
import blogPostApp.repository.PostsRepository;

@Service
public class CommentServiceImpel implements CommentService{

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private PostsRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public CommentDTO addNewCommentTOPost(CommentDTO commentDto, Integer PostId) {
		// TODO Auto-generated method stub
		Comment comment = this.modelmapper.map(commentDto,Comment.class);
		
		Posts post = this.postRepository.findById(PostId).orElseThrow(()->new ResourceNotFoundException("post","id",PostId));
		
		comment.setPost(post);
	
		
		Comment savedComment = this.commentRepo.save(comment);
		///post.setComment(savedComment);
		
		return this.modelmapper.map(savedComment,CommentDTO.class);
	}

	@Override
	public List<CommentDTO> fetchAllCommentOnPost(Integer PostId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDTO getCommentOnPost(Integer PostId, Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
