/**
 * 
 */
package com.learn.restfulwebservicesconcepts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ancil Hameed
 * 
 * Added : 15-Sep-2021, 12:35:34 am
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
