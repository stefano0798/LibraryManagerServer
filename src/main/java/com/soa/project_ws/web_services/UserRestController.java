package com.soa.project_ws.web_services;

import com.soa.project_ws.web_services.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private DataManager dataManager = DataManager.getInstance();

	@GetMapping
	public Object[] get() {
		return dataManager.getUserList().toObjectArray();
	}

	@GetMapping("/{email}")
	public Object getByEmailAddress(@PathVariable String email) {
		return dataManager.getUserList().getByEmailAddress(email);
	}

	@PostMapping
	public User createUser(@RequestBody User u) {
		dataManager.getUserList().addUser(u);
		dataManager.saveUserList();

		return u;
	}

}
