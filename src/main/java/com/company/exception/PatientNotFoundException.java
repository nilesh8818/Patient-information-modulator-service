package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @since 04-Jul-2019 7:57:49 am
 *
 */
@SuppressWarnings ("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception{

	/**
	 * @param message
	 */
	public PatientNotFoundException (String message) {
		super (message);
	}
	

}
