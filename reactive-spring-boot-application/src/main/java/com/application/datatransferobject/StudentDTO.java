package com.application.datatransferobject;

import org.springframework.stereotype.Component;

public class StudentDTO {

	private String firstName;
	private String lastName;
	private String emailId;
	private String address;
	private String phoneNumber;
	
	public StudentDTO()
	{
		
	}

	public StudentDTO(String firstName, String LastName, String emailId, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = LastName;
		this.emailId = emailId;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return firstName + ":" + lastName + ":" + emailId + ":" + address + ":" + phoneNumber;

	}
}
