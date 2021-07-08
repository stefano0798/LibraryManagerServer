package com.soa.project_ws.web_services.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Book {
	private String isbn, title, author, shipped;

	@JsonCreator
	public Book(String isbn, String title, String author, String shipped) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.shipped = shipped;
	}

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.shipped = "false";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShipped() {
		return shipped;
	}

	public void setShipped(String shipped) {
		this.shipped = shipped;
	}
}
