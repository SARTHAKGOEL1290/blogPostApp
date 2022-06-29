package blogPostApp.service;

import java.util.List;

import blogPostApp.dto.CommentDTO;

public interface CommentService {
	
	// create new comment
	CommentDTO addNewCommentTOPost(CommentDTO commentDto , Integer PostId);
	
	// get all comments on post
	List<CommentDTO> fetchAllCommentOnPost(Integer PostId);
	
	// CommentDTO fetch a particular post
	
	CommentDTO getCommentOnPost(Integer PostId,Integer commentId);
	

}
