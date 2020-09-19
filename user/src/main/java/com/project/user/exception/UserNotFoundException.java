package com.project.user.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(int id) {
		super("User with id "+id+" not found");
	}
}
