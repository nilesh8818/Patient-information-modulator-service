package com.company.patinet.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.exception.PatientBadRequestException;
import com.company.exception.PatientNotFoundException;
import com.company.patinet.exposedpojo.PatientExposed;
import com.company.patinet.serviceImpl.PatientServiceImpl;

/**
 * @since 04-Jul-2019 7:46:41 am
 *
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PatientGetController {

	private final Logger		log	= LoggerFactory.getLogger (PatientGetController.class);

	@Autowired
	private PatientServiceImpl	patientServiceImpl;

	/**
	 * @param firstName
	 * @return
	 * @throws PatientBadRequestException
	 * @throws PatientNotFoundException
	 */
	@RequestMapping (value = "/getpatientbyname", method = RequestMethod.GET)
	public ResponseEntity <PatientExposed> getPatientByParticularName (
		@RequestParam (name = "firstName", required = true) String firstName)
		throws PatientBadRequestException, PatientNotFoundException {

		log.info ("patient search by firstname is=" + firstName);
		PatientExposed patientExposed = patientServiceImpl.getPatientByParticularName (firstName);

		if (StringUtils.isEmpty (patientExposed.toString ())) {
			log.info ("patient is not found");
			return new ResponseEntity <> (HttpStatus.NO_CONTENT);
		}
		else {
			log.info ("patient found for particular firstname =" + firstName);
			return new ResponseEntity <PatientExposed> (patientExposed, HttpStatus.OK);
		}

	}

	/**
	 * @param firstName
	 * @return
	 * @throws PatientBadRequestException
	 * @throws PatientNotFoundException
	 */
	@RequestMapping (value = "/getallpatient", method = RequestMethod.GET)
	public ResponseEntity <List <PatientExposed>> getAllPatient ()
		throws PatientBadRequestException, PatientNotFoundException {

		log.info ("find all patient");
		List <PatientExposed> patientExposed = patientServiceImpl.getAllPatient ();

		if (StringUtils.isEmpty (patientExposed.toString ())) {
			log.info ("patient List is not found");
			return new ResponseEntity <> (HttpStatus.NO_CONTENT);
		}
		else {
			log.info ("List of patient found");
			return new ResponseEntity <List <PatientExposed>> (patientExposed, HttpStatus.OK);
		}

	}

}
