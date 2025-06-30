package in.sp.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(value = {UserIsNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException
	(UserIsNotFoundException userIsNotFoundException)
	{
		UserException userException= new UserException(
				userIsNotFoundException.getMessage(), 
				userIsNotFoundException.getCause(),
				HttpStatus.NOT_FOUND
		);
		return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
}
