package com.soa.project_ws.web_services.collections;

import com.soa.project_ws.web_services.DataManager;
import com.soa.project_ws.web_services.entities.Book;
import com.soa.project_ws.web_services.entities.Loan;
import com.soa.project_ws.web_services.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LoanList {

	private ArrayList<Loan> loanList;
	private UserList ul;
	private BookInventory bi;

	public LoanList(UserList userList, BookInventory bookInventory) {

		this.bi = bookInventory;
		this.ul = userList;

		this.loanList = new ArrayList<>();
	}

	public Object[] usersByIsbn(String isbn) {

		UserList tmp = new UserList();

		for (Loan l : loanList) {
			if (l.getIsbn().equals(isbn)) {
				tmp.addUser((User) ul.getByEmailAddress(l.getEmailAddress()));
			}
		}

		return tmp.toObjectArray();


	}

	public Object[] booksByEmail(String email) {

		BookInventory tmp = new BookInventory();

		for (Loan l : loanList) {
			if (l.getEmailAddress().equals(email)) {
				tmp.addBook((Book) bi.getBookByISBN(l.getIsbn()) );
			}
		}

		return tmp.toObjectArray();

	}

	public Object[] toObjectArray() {
		return this.loanList.toArray();
	}

	public void addLoan(String mailAddress, String isbn) {
		if (mailAddress != null && !mailAddress.isBlank() && isbn != null && !isbn.isBlank()) {
			this.loanList.add(new Loan(isbn, mailAddress));
		}
	}


	public void addLoan(Loan l) {
		this.addLoan(l.getEmailAddress(), l.getIsbn());
	}

	public ArrayList<Loan> getLoanList() {
		return loanList;
	}
}
