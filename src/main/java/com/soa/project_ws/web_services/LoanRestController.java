package com.soa.project_ws.web_services;

import com.soa.project_ws.web_services.entities.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/loan")
public class LoanRestController {

	private DataManager dataManager = DataManager.getInstance();

	@GetMapping
	public Object[] get() {
		return dataManager.getLoanList().toObjectArray();
	}

	@GetMapping("/user/{mailAddress}")
	public Object[] getLoansByMailAddress(@PathVariable String mailAddress) {
		return dataManager.getLoanList().booksByEmail(mailAddress);
	}

	@GetMapping("/book/{isbn}")
	public Object[] getLoansByIsbn(@PathVariable String isbn) {
		return dataManager.getLoanList().usersByIsbn(isbn);
	}

	@PostMapping
	public Loan addLoan(@RequestBody Loan l) {
		dataManager.getLoanList().addLoan(l);
		dataManager.saveLoanList();
		return l;
	}

}
