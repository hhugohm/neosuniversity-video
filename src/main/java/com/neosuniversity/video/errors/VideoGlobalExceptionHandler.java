/******************************************************************************************
Copyright (c) 2020 NeosSoftware Corporation

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is furnished
to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
************************************************************************************************/
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

import com.neosuniversity.video.util.ErrorMappingUtilI;



/**
 * The Class VideoGlobalExceptionHandler.
 * 
 * @author Neosuniversity
 * @version 1.0 
 */
@ControllerAdvice
public class VideoGlobalExceptionHandler extends ResponseEntityExceptionHandler implements ErrorMappingUtilI {

	
	/**
	 * Handle country not found.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<Object> handleCountryNotFound(CountryNotFoundException ex) {
		ErrorMapping apiError = new ErrorMapping(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ExceptionUtils.getStackTrace(ex));
		return buildResponseEntity(apiError);

	}
	
	/**
	 * Handle movie not found.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<Object> handleMovieNotFound(MovieNotFoundException ex) {
		ErrorMapping apiError = new ErrorMapping(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ExceptionUtils.getStackTrace(ex));
		return buildResponseEntity(apiError);

	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
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
