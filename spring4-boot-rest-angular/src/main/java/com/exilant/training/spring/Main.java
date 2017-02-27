package com.exilant.training.spring;

import com.exilant.training.spring.jpa.entity.Task;
import com.exilant.training.spring.jpa.repo.TaskRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		TaskRepositoryImpl dao = new TaskRepositoryImpl();
		Task user = new Task();
		user = dao.save(user);
		System.out.println("Created User: " + user);
	}

}
