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

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ErrorMapping.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
@Setter
@Getter
public class ErrorMapping {

	/** The status. */
	private HttpStatus status;
	
	/** The timestamp. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	/** The message. */
	private String message;
	
	/** The debug message. */
	private String debugMessage;

	/**
	 * Instantiates a new error mapping.
	 */
	private ErrorMapping() {
		timestamp = LocalDateTime.now();
	}

	/**
	 * Instantiates a new error mapping.
	 *
	 * @param status the status
	 */
	ErrorMapping(HttpStatus status) {
		this();
		this.status = status;
	}

	/**
	 * Instantiates a new error mapping.
	 *
	 * @param status the status
	 * @param ex     the ex
	 */
	ErrorMapping(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	/**
	 * Instantiates a new error mapping.
	 *
	 * @param status  the status
	 * @param message the message
	 * @param ex      the ex
	 */
	ErrorMapping(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}
