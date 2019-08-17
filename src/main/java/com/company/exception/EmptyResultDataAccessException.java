package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @since 06-Jul-2019 11:11:07 am
 *
 */
@SuppressWarnings ("serial")
@ResponseStatus (code = HttpStatus.NOT_FOUND)
public class EmptyResultDataAccessException extends Exception {

	/**
	 * @param message
	 */
	public EmptyResultDataAccessException (String message) {
		super (message);
	}
}
