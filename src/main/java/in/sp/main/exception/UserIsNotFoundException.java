package in.sp.main.exception;

public class UserIsNotFoundException extends RuntimeException{

	public UserIsNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserIsNotFoundException(String message) {
		super(message);
		
	}
	
}
