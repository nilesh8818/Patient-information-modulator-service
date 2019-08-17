package com.company.patinet.rest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.exception.PatientBadRequestException;
import com.company.exception.PatientNotFoundException;
import com.company.patinet.exposedpojo.PatientExposed;
import com.company.patinet.pojo.Patient;
import com.company.patinet.serviceImpl.PatientServiceImpl;

/**
 * @since 04-Jul-2019 7:45:27 am
 *
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PatientSaveController {
	
	private final Logger log = LoggerFactory.getLogger(PatientSaveController.class);
	
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	/**
	 * @param patient
	 * @return
	 * @throws PatientBadRequestException
	 * @throws PatientNotFoundException
	 */
	@RequestMapping(value = "/make", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <PatientExposed> createNewPatient(@RequestBody Patient patient) throws PatientBadRequestException, PatientNotFoundException
	{
		log.info ("Patient demographic which is pass through patient is",patient);
		
		PatientExposed patientExposed=patientServiceImpl.createNewPatinets (patient);
		
		if(StringUtils.isEmpty (patientExposed.toString ())) {
			log.info ("patient is not stored");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			log.info ("patient stored successfully");
			return new ResponseEntity<PatientExposed>(patientExposed, HttpStatus.OK);
		}
	}

}
