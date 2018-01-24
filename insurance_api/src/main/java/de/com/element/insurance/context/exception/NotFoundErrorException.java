package de.com.element.insurance.context.exception;

import org.springframework.http.HttpStatus;

public class NotFoundErrorException extends RuntimeException{
	
	private static final long serialVersionUID = -5437766330824492667L;
	private final HttpStatus status;
	private final String message;
	
	public NotFoundErrorException(final String message) {
		
		this.status = HttpStatus.NOT_FOUND;
		this.message = message;
		
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
