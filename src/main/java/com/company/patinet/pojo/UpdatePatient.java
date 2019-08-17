package com.company.patinet.pojo;

import java.math.BigInteger;

/**
 * @since 10-Aug-2019 8:21:04 pm
 *
 */
public class UpdatePatient {

	private BigInteger	patientId;

	private String		firstName;

	private String		lastName;

	private String		state;

	private String		city;

	/**
	 * @since 04-Jul-2019
	 */
	public UpdatePatient () {
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
	public UpdatePatient (BigInteger patientId, String firstName, String lastName, String state,
		String city) {
		super ();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.city = city;
	}

	/**
	 * @return
	 */
	public BigInteger getPatientId () {
		return patientId;
	}

	/**
	 * @param patientId
	 */
	public void setPatientId (BigInteger patientId) {
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

	
}
