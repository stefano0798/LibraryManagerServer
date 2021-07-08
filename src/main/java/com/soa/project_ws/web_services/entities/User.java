package com.soa.project_ws.web_services.entities;

public class User {

	private String emailAddress, name, surname;

	public User(String emailAddress, String name, String surname) {
		this.emailAddress = emailAddress;
		this.name = name;
		this.surname = surname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
