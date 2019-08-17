package com.company.patinet.serviceImpl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.exception.EmptyResultDataAccessException;
import com.company.exception.PatientBadRequestException;
import com.company.exception.PatientNotFoundException;
import com.company.patinet.exposedpojo.PatientExposed;
import com.company.patinet.pojo.Patient;
import com.company.patinet.service.PatientService;

/**
 * @since 04-Jul-2019 7:50:22 am
 *
 */
@Service
public class PatientServiceImpl implements PatientService {

	private final Logger			log				= LoggerFactory
		.getLogger (PatientServiceImpl.class);

	@Value ("${patient.base.url}")
	private String					patientBaseUrl;

	@Autowired
	@Qualifier (value = "loadBalancedPatientModulatorService")
	private RestTemplate			resttemplate;

	private static PatientExposed	patientExposed	= null;

	// Patient save api
	@Override
	public PatientExposed createNewPatinets (Patient patient)
		throws PatientBadRequestException, PatientNotFoundException {
		log.info ("patient object is=" + patient);

		String patientSaveUrl = String.format ("%s%s", patientBaseUrl, "/makepatient");
		log.info ("Created url for save patient is:" + patientSaveUrl);

		if (StringUtils.isEmpty (patient.toString ())) {
			throw new PatientBadRequestException ("patient should not be empty");
		}

		try {
			HttpHeaders headers = new HttpHeaders ();
			headers.setContentType (MediaType.APPLICATION_JSON);
			HttpEntity <Patient> entity = new HttpEntity <Patient> (patient, headers);
			patientExposed = resttemplate
				.exchange (patientSaveUrl, HttpMethod.POST, entity, PatientExposed.class)
				.getBody ();
		}
		catch (HttpClientErrorException | HttpServerErrorException e) {

			if (e.getStatusCode ()
				.equals (HttpStatus.NOT_FOUND)) {
				throw new PatientNotFoundException ("Patient is not stored");
			}
			else if (e.getStatusCode ()
				.equals (HttpStatus.BAD_REQUEST)) {
				throw new PatientBadRequestException ("Patient request should not be empty");
			}
		}
		return patientExposed;
	}

	@Override
	public PatientExposed getPatientByParticularName (String firstName)
		throws PatientNotFoundException {

		log.info ("get patient by using first name=" + firstName);
		String getPatientByFirstNameUrl = String.format ("%s%s", patientBaseUrl,
			"/getpatientbyname");

		// to make the url and add the querry param in to url
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString (getPatientByFirstNameUrl)
			.queryParam ("firstName", firstName);
		log.info ("Created url for get all patient is=" + builder.buildAndExpand ()
			.toUri ());

		try {
			HttpHeaders headers = new HttpHeaders ();
			HttpEntity <PatientExposed> entity = new HttpEntity <PatientExposed> (headers);
			patientExposed = resttemplate.exchange (builder.buildAndExpand ()
				.toUri (), HttpMethod.GET, entity, PatientExposed.class)
				.getBody ();
		}

		catch (HttpClientErrorException | HttpServerErrorException e) {
			if (e.getStatusCode ()
				.equals (HttpStatus.NOT_FOUND)) {
				log.error ("patient not found for particular name=" + firstName);
				throw new PatientNotFoundException (
					"patient not found for particular id=" + firstName);
			}
		}

		return patientExposed;
	}

	// get all patient list
	@Override
	public List <PatientExposed> getAllPatient () throws PatientNotFoundException {

		List <PatientExposed> patientExposedList = null;
		String getAllPatientUrl = String.format ("%s%s", patientBaseUrl, "/getallpatient");
		log.info ("Created url for get all patient is=" + getAllPatientUrl);

		try {
			HttpHeaders headers = new HttpHeaders ();
			HttpEntity <
				List <PatientExposed>> entity = new HttpEntity <List <PatientExposed>> (headers);
			patientExposedList = resttemplate.exchange (getAllPatientUrl, HttpMethod.GET, entity,
				new ParameterizedTypeReference <List <PatientExposed>> () {
				})
				.getBody ();
		}
		catch (HttpClientErrorException | HttpServerErrorException e) {
			if (e.getStatusCode ()
				.equals (HttpStatus.NOT_FOUND)) {
				log.error ("List of patient not found");
				throw new PatientNotFoundException ("List of patient not found");
			}
		}

		return patientExposedList;
	}

	@Override
	public PatientExposed updateExistingPatient (Patient patient, BigInteger id)
		throws PatientBadRequestException, PatientNotFoundException {

		String updatePatientUrl = String.format ("%s%s%s%s", patientBaseUrl, "/updatepatient", "/",
			id);
		log.info ("Created url for update patient is=" + updatePatientUrl);

		if (patient.getFirstName ()
			.isEmpty ()
			| patient.getLastName ()
				.isEmpty ()
			| patient.getState ()
				.isEmpty ()
			| patient.getCity ()
				.isEmpty ()) {
			throw new PatientBadRequestException ("patient should not be empty");
		}

		try {
			HttpHeaders headers = new HttpHeaders ();
			headers.setContentType (MediaType.APPLICATION_JSON);
			HttpEntity <Patient> entity = new HttpEntity <Patient> (patient, headers);
			patientExposed = resttemplate
				.exchange (updatePatientUrl, HttpMethod.PUT, entity, PatientExposed.class)
				.getBody ();
		}
		catch (HttpClientErrorException | HttpServerErrorException e) {

			if (e.getStatusCode ()
				.equals (HttpStatus.BAD_REQUEST)) {
				throw new PatientBadRequestException ("Patient Request should not be empty");
			}
			else if (e.getStatusCode ()
				.equals (HttpStatus.NOT_FOUND)) {
				throw new PatientNotFoundException ("Patient not found");
			}
		}

		return patientExposed;
	}

	/**
	 * @param id
	 * @throws PatientNotFoundException
	 * @throws PatientBadRequestException
	 */
	@Override
	public String deleteExistingPatient (BigInteger id)
		throws EmptyResultDataAccessException, PatientNotFoundException {
		String deleteMessage = null;

		String deletePatientUrl = String.format ("%s%s%s%s", patientBaseUrl, "/deletepatient", "/",
			id);
		log.info ("Created url for delete patient is=" + deletePatientUrl);

		try {
			HttpHeaders headers = new HttpHeaders ();
			headers.setContentType (MediaType.APPLICATION_JSON);
			HttpEntity <String> entity = new HttpEntity <String> (headers);
			deleteMessage = resttemplate
				.exchange (deletePatientUrl, HttpMethod.DELETE, entity, String.class)
				.getBody ();
		}
		catch (HttpClientErrorException | HttpServerErrorException e) {
			if (e.getStatusCode ()
				.equals (HttpStatus.NOT_FOUND)) {
				throw new PatientNotFoundException ("Patient not found");
			}
		}

		return deleteMessage;
	}

}
