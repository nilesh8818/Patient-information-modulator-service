package com.company.patinet.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @since 04-Jul-2019 7:54:39 am
 *
 */

public class Patient {

	private BigInteger	patientId;

	private String		firstName;

	private String		lastName;

	private String		state;

	private String		city;

	private String		guid;

	private Date		createdDate;

	private Date		updatedDate;

	/**
	 * @since 04-Jul-2019
	 */
	public Patient () {
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
	public Patient (BigInteger patientId, String firstName, String lastName, String state,
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
	public Date getCreatedDate () {
		return createdDate;
	}

	/**
	 * @param date
	 */
	public void setCreatedDate (Date date) {
		this.createdDate = date;
	}

	/**
	 * @return
	 */
	public Date getUpdatedDate () {
		return updatedDate;
	}

	/**
	 * @param date
	 */
	public void setUpdatedDate (Date date) {
		this.updatedDate = date;
	}

}
