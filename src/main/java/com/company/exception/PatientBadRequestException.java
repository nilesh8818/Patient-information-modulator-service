package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @since 04-Jul-2019 7:57:40 am
 *
 */
@SuppressWarnings ("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PatientBadRequestException extends Exception{

	/**
	 * @param message
	 */
	public PatientBadRequestException (String message) {
		super (message);
	}
}
