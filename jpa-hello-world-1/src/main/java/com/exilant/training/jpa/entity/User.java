package com.exilant.training.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String emailId;
	private String password;

	protected User() {
	}

	public User(String firstName, String emailId, String password) {
		this.firstName = firstName;
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", emailId=" + emailId + ", password=" + password + "]";
	}
}
