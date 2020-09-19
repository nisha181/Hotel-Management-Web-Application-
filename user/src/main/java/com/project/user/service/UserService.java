package com.project.user.service;

import java.util.List;

import com.project.user.exception.UserNotFoundException;
import com.project.user.model.User;

public interface UserService {

	public User find(int id);

	public List<User> getAll();

	public String addUser(User userDetails);

	public String updateUser(User userDetails) throws UserNotFoundException;

	public String deleteUser(int id);

}
