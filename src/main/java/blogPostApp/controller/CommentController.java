package blogPostApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blogPostApp.dto.CommentDTO;
import blogPostApp.service.CommentServiceImpel;

@RestController
@RestControllerAdvice
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentServiceImpel commentService;
	
	@PostMapping("/{postId}/addComment")
	public ResponseEntity<CommentDTO> addNewCommentOnPostController(@RequestBody CommentDTO comment,@PathVariable("postId") Integer postId)
	{
		CommentDTO commentDto = this.commentService.addNewCommentTOPost(comment, postId);
		return new ResponseEntity<CommentDTO>(commentDto,HttpStatus.CREATED);
	}
}
