package blogPostApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blogPostApp.helper.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandelling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> ResourceNotFoundExceptionHandller(ResourceNotFoundException ex)
	{
		String message = ex.getMessage();
		APIResponse apiResponse = new APIResponse(message, false);
		System.out.println("Hello------------------------------------");
		return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> MethodArgumentNotValidExceptionHandller(MethodArgumentNotValidException ex)
	{
		Map<String,String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName = ((FieldError)error).getField();
		String message   = error.getDefaultMessage();
				
	     map.put(fieldName, message);			
		});
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
	}

}
