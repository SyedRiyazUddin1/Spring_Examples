package com.firstwebapp;

public class UserValidationService {

	public boolean validateUser(String user, String password) {

		return (user.equalsIgnoreCase("Riyaz") && password.equals("Techie"));

	}

}
