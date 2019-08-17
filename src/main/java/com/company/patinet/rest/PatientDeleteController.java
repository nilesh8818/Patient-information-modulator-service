package com.company.patinet.rest;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.exception.EmptyResultDataAccessException;
import com.company.exception.PatientBadRequestException;
import com.company.exception.PatientNotFoundException;
import com.company.patinet.serviceImpl.PatientServiceImpl;

/**
 * @since 06-Jul-2019 10:20:15 am
 *
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PatientDeleteController {

	private final Logger		log	= LoggerFactory.getLogger (PatientDeleteController.class);

	@Autowired
	private PatientServiceImpl	patientServiceImpl;

	/**
	 * @param id
	 * @return
	 * @throws PatientBadRequestException
	 * @throws PatientNotFoundException
	 * @throws EmptyResultDataAccessException
	 */
	@RequestMapping (value = "/deletepatient/{id}", method = RequestMethod.DELETE)
	public ResponseEntity <String> deleteExistingPatient (@PathVariable BigInteger id)
		throws EmptyResultDataAccessException, PatientNotFoundException {
		log.info ("Patient demographic delete for particular id=" + id);

		String patientExposed = patientServiceImpl.deleteExistingPatient (id);

		if (StringUtils.isEmpty (patientExposed)) {
			log.error ("patient is not deletd");
			return new ResponseEntity <> (HttpStatus.NO_CONTENT);
		}
		else {
			log.info ("patient updated successfully");
			return new ResponseEntity <String> (patientExposed, HttpStatus.OK);
		}
	}

}
