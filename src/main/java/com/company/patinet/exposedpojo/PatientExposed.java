package com.company.patinet.exposedpojo;

import java.sql.Timestamp;

/**
 * @since 04-Jul-2019 7:56:01 am
 *
 */
public class PatientExposed {

	private String		patientId;

	private String		firstName;

	private String		lastName;

	private String		state;

	private String		city;

	private String		guid;

	private Timestamp	createdDate;

	private Timestamp	updatedDate;

	/**
	 * 
	 */
	public PatientExposed () {
		super ();
	}

	/**
	 * @param patientId
	 * @param firstName
	 * @param lastName
	 * @param state
	 * @param city
	 * @param guid
	 * @param createdDate
	 * @param updatedDate
	 */
	public PatientExposed (String patientId, String firstName, String lastName, String state,
		String city, String guid, Timestamp createdDate, Timestamp updatedDate) {
		super ();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.city = city;
		this.guid = guid;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	/**
	 * @return
	 */
	public String getPatientId () {
		return patientId;
	}

	/**
	 * @param patientId
	 */
	public void setPatientId (String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return
	 */
	public String getFirstName () {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName () {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getState () {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState (String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getCity () {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity (String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getGuid () {
		return guid;
	}

	/**
	 * @param guid
	 */
	public void setGuid (String guid) {
		this.guid = guid;
	}

	/**
	 * @return
	 */
	public Timestamp getCreatedDate () {
		return createdDate;
	}

	/**
	 * @param createdDate
	 */
	public void setCreatedDate (Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return
	 */
	public Timestamp getUpdatedDate () {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 */
	public void setUpdatedDate (Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}
