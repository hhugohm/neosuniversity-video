package com.neosuniversity.video.errors;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.neosuniversity.video.util.ErrorMappingUtilsI;



@ControllerAdvice
public class VideoGlobalExceptionHandler extends ResponseEntityExceptionHandler implements ErrorMappingUtilsI {

	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<Object> handleCountryNotFound(CountryNotFoundException ex) {
		ErrorMapping apiError = new ErrorMapping(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ExceptionUtils.getStackTrace(ex));
		return buildResponseEntity(apiError);

	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		
		ErrorMapping apiError = new ErrorMapping(HttpStatus.BAD_REQUEST);
		apiError.setMessage(errors.toString());
		apiError.setDebugMessage(ExceptionUtils.getStackTrace(ex));
		return buildResponseEntity(apiError);

	}

}
