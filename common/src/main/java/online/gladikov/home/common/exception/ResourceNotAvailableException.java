package online.gladikov.home.common.exception;

public class ResourceNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ResourceNotAvailableException(String message) {
		super(message);
	}


}
