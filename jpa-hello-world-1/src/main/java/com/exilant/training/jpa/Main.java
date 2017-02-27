package com.exilant.training.jpa;

import com.exilant.training.jpa.entity.User;
import com.exilant.training.jpa.repo.UserDAO;

public class Main {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User user = new User("Vijay", "vijay@exilant.com", "secreat");
		user = dao.save(user);
		System.out.println("Created User: " + user);
	}

}
