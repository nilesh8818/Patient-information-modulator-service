package com.company.patinet.rest;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 06-Jul-2019 9:51:42 am
 *
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PatientUpdateController {
	
	private final Logger		log	= LoggerFactory.getLogger (PatientUpdateController.class);
	
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	/**
	 * @param patient
	 * @param id
	 * @return exposed patient
	 * @throws PatientBadRequestException
	 * @throws PatientNotFoundException
	 */
	@RequestMapping(value = "/updatepatient/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <PatientExposed> updateExistingPatient(@RequestBody Patient patient,@PathVariable BigInteger id) throws PatientBadRequestException, PatientNotFoundException
	{
		log.info ("Patient demographic which is pass through patient is for update the patient="+patient);
		
		PatientExposed patientExposed=patientServiceImpl.updateExistingPatient (patient,id);
		
		if(StringUtils.isEmpty (patientExposed.toString ())) {
			log.error ("patient is not updated");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			log.info ("patient updated successfully");
			return new ResponseEntity<PatientExposed>(patientExposed, HttpStatus.OK);
		}
	}

}
