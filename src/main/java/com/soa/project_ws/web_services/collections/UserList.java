package com.soa.project_ws.web_services.collections;

import com.soa.project_ws.web_services.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserList {

	private ArrayList<User> userList;

	public UserList() {
		userList = new ArrayList<>();
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public Object[] toObjectArray() {
		return userList.toArray();
	}

	public Object getByEmailAddress(String emailAddress) {
		User tmp = null;
		for (User u : userList) {
			if (u.getEmailAddress().equals(emailAddress)) {
				tmp = u;
			}
		}
		return tmp;
	}

	public void addUser(User u) {
		if (u != null)
			userList.add(u);
	}

}
