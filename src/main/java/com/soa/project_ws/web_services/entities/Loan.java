package com.soa.project_ws.web_services.entities;

import java.time.LocalDate;

public class Loan {

	private String isbn, emailAddress;
	private LocalDate startLoan;

	public Loan(String isbn, String emailAddress) {
		this.isbn = isbn;
		this.emailAddress = emailAddress;
		this.startLoan =  LocalDate.now();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public LocalDate getStartLoan() {
		return startLoan;
	}

}
