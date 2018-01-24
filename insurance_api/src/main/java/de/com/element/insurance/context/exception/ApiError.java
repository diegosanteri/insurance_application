package de.com.element.insurance.context.exception;

import org.springframework.http.HttpStatus;

/**
 * @author diegosanteri
 *
 */
public class ApiError {

	private final HttpStatus code;
	private final String message;
	
	public ApiError(final HttpStatus code, final String message) {
		
		this.code = code;
		this.message = message;
	}
	
	public HttpStatus getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
