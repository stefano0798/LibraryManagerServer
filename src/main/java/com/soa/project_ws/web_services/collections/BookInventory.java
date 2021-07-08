package com.soa.project_ws.web_services.collections;

import com.soa.project_ws.web_services.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookInventory {

	private ArrayList<Book> bookInventory;

	public BookInventory() {
		this.bookInventory = new ArrayList<>();
	}

	public Object[] toObjectArray() {
		return bookInventory.toArray();
	}

	public Object getBookByISBN(String isbn) {

		Book tmp = null;

		for (int i=0; i<bookInventory.size() && tmp == null; i++) {
			Book current = bookInventory.get(i);
			if (current.getIsbn().equals(isbn)) {
				tmp = current;
			}
		}

		return tmp;
	}

	public Book getBookEntityByISBN(String isbn) {

		Book tmp = null;

		for (int i=0; i<bookInventory.size() && tmp == null; i++) {
			Book current = bookInventory.get(i);
			if (current.getIsbn().equals(isbn)) {
				tmp = current;
			}
		}

		return tmp;
	}

	public void addBook(Book b) {
		if (b != null)
			bookInventory.add(b);
	}

	public ArrayList<Book> getBookInventory() {
		return bookInventory;
	}
}
