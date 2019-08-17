package com.company.patinet.service;

import java.math.BigInteger;
import java.util.List;

import com.company.exception.EmptyResultDataAccessException;
import com.company.exception.PatientBadRequestException;
import com.company.exception.PatientNotFoundException;
import com.company.patinet.exposedpojo.PatientExposed;
import com.company.patinet.pojo.Patient;


/**
 * @since 04-Jul-2019 7:39:48 am
 *
 */
public interface PatientService {

	/**
	 * @param patient
	 * @return objcet
	 * @throws PatientBadRequestException
	 * @throws PatientNotFoundException 
	 */
	PatientExposed createNewPatinets(Patient patient) throws PatientBadRequestException, PatientNotFoundException;
	
	/**
	 * @param firstName
	 * @return object
	 * @throws PatientBadRequestException 
	 * @throws PatientNotFoundException 
	 */
	PatientExposed getPatientByParticularName(String firstName) throws PatientBadRequestException, PatientNotFoundException;
	
	/**
	 * @return all patient
	 * @throws PatientNotFoundException 
	 */
	List <PatientExposed> getAllPatient () throws PatientNotFoundException;
	
	 /**
	 * @param patient
	 * @param id
	 * @return object
	 * @throws PatientBadRequestException 
	 * @throws PatientNotFoundException 
	 */
	PatientExposed updateExistingPatient (Patient patient, BigInteger id) throws PatientBadRequestException, PatientNotFoundException;

	/**
	 * @param id
	 * @return object
	 * @throws PatientBadRequestException
	 * @throws EmptyResultDataAccessException 
	 * @throws PatientNotFoundException 
	 */
	String deleteExistingPatient (BigInteger id) throws EmptyResultDataAccessException, PatientNotFoundException;
}
