package com.soa.project_ws.web_services;

import com.soa.project_ws.web_services.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookRestController {

	private DataManager dataManager = DataManager.getInstance();

	@GetMapping
	public Object[] get() {
		return dataManager.getInventory().toObjectArray();
	}

	@GetMapping("/{isbn}")
	public Object getBook(@PathVariable String isbn) {
		return dataManager.getInventory().getBookByISBN(isbn);
	}

	@PostMapping
	public Book addBook(@RequestBody Book b) {
		dataManager.getInventory().addBook(b);
		dataManager.saveInventory();

		return b;
	}

}
