package de.com.element.insurance.context.exception;

import org.springframework.http.HttpStatus;

/**
 * @author diegosanteri
 *
 */
public class BusinessErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1216273259371404527L;
	private final HttpStatus status;
	private final String message;
	
	public BusinessErrorException(final String message) {
		
		this.status = HttpStatus.UNPROCESSABLE_ENTITY;
		this.message = message;
		
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
