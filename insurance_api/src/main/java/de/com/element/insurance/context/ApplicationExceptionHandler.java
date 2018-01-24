package de.com.element.insurance.context;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.com.element.insurance.context.exception.ApiError;
import de.com.element.insurance.context.exception.BusinessErrorException;
import de.com.element.insurance.context.exception.NotFoundErrorException;

/**
 * @author diegosanteri
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class })
	protected ResponseEntity<ApiError> handleIllegalArgument(IllegalArgumentException exception) {

		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage()));
	}

	@ExceptionHandler(value = { BusinessErrorException.class })
	protected ResponseEntity<ApiError> handleBusinessException(BusinessErrorException exception) {

		return buildResponseEntity(new ApiError(exception.getStatus(), exception.getMessage()));
	}

	@ExceptionHandler(value = { NotFoundErrorException.class })
	protected ResponseEntity<ApiError> handleNotFoundException(NotFoundErrorException exception) {

		return buildResponseEntity(new ApiError(exception.getStatus(), exception.getMessage()));
	}
	
	@Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ApiError(status, ex.getMessage()), status);
    }
	

	private ResponseEntity<ApiError> buildResponseEntity(final ApiError apiError) {

		return new ResponseEntity<ApiError>(apiError, apiError.getCode());
	}
}
