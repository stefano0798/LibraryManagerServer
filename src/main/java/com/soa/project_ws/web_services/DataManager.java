package com.soa.project_ws.web_services;

import com.soa.project_ws.web_services.collections.BookInventory;
import com.soa.project_ws.web_services.collections.LoanList;
import com.soa.project_ws.web_services.collections.UserList;
import com.soa.project_ws.web_services.entities.Book;
import com.soa.project_ws.web_services.entities.Loan;
import com.soa.project_ws.web_services.entities.User;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class DataManager {


	private static final String USER_FILE_NAME = "userList.csv";
	private static final String BOOK_FILE_NAME = "bookInventory.csv";
	private static final String LOAN_FILE_NAME = "loanList.csv";

	private static DataManager dataManager = null;

	private BookInventory inventory;
	private UserList userList;
	private LoanList loanList;

	private DataManager() {
		this.inventory = new BookInventory();
		this.userList = new UserList();

		loanList = new LoanList(this.userList, this.inventory);

		loadInventory();
		loadUserList();
		loadLoanList();
	}

	private void loadInventory() {
		String line = null;

		File f = new File(BOOK_FILE_NAME);
		if (!f.exists())
			return;

		try {
			BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE_NAME));

			line = br.readLine();
			Book tmp;
			while (line != null) {
				System.out.println(line);
				String isbn = line.split(",")[0];
				String title = line.split(",")[1];
				String author = line.split(",")[2];
				String shipped = line.split(",")[3].substring(0, line.split(",")[3].length()-1);
				tmp = new Book(isbn, title, author, shipped);
				inventory.addBook(tmp);
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void loadUserList() {
		String line = null;

		File f = new File(USER_FILE_NAME);
		if (!f.exists())
			return;

		try {
			BufferedReader br = new BufferedReader(new FileReader(USER_FILE_NAME));

			line = br.readLine();
			User tmp;
			while (line != null) {
				System.out.println(line);
				String emailAddress = line.split(",")[0];
				String name = line.split(",")[1];
				String surname = line.split(",")[2].substring(0, line.split(",")[2].length()-1);
				tmp = new User(emailAddress, name, surname);
				userList.addUser(tmp);
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadLoanList() {
		String line = null;

		File f = new File(LOAN_FILE_NAME);
		if (!f.exists())
			return;

		try {
			BufferedReader br = new BufferedReader(new FileReader(LOAN_FILE_NAME));

			line = br.readLine();
			Loan tmp;
			while (line != null) {
				System.out.println(line);
				String isbn = line.split(",")[0];
				String emailAddress = line.split(",")[1].substring(0, line.split(",")[1].length()-1);
				tmp = new Loan(isbn, emailAddress);
				loanList.addLoan(tmp);
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DataManager getInstance() {
		if (dataManager == null) {
			dataManager = new DataManager();
		}
		return dataManager;
	}

	public BookInventory getInventory() {
		return this.inventory;
	}

	public UserList getUserList() {
		return this.userList;
	}

	public LoanList getLoanList() {
		return this.loanList;
	}

	public void saveInventory() {
		File f = new File(BOOK_FILE_NAME);
		try {
			if (f.exists())
				f.delete();

			BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE_NAME));
			for (Book u : inventory.getBookInventory()) {
				String line = u.getIsbn() + "," + u.getTitle() + "," + u.getAuthor() + "," + u.getShipped() + ";";
				bw.append(line);
			}

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveUserList() {
		File f = new File(USER_FILE_NAME);
		try {
			if (f.exists())
				f.delete();

			BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE_NAME));
			for (User u : userList.getUserList()) {
				String line = u.getEmailAddress() + "," + u.getName() + "," + u.getSurname() + ";";
				bw.append(line);
			}

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveLoanList() {
		File f = new File(LOAN_FILE_NAME);
		try {
			if (f.exists())
				f.delete();

			BufferedWriter bw = new BufferedWriter(new FileWriter(LOAN_FILE_NAME));
			for (Loan u : loanList.getLoanList()) {
				String line = u.getIsbn() + "," + u.getEmailAddress() + ";";
				bw.append(line);
			}

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}