package com.project.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.user.exception.UserNotFoundException;
import com.project.user.model.User;
import com.project.user.resources.UserRepository;

import lombok.extern.java.Log;

@Log
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public User find(int id) {
		return userRepository.findById(id).get();
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public String addUser(User userDetails) {
		log.info("START");
		if (!getAll().contains(userDetails))
			userRepository.save(userDetails);
		else
			return "NOT SUCCESS";
		log.info("STOP");
		return "SUCCESS";
	}

	@Override
	public String updateUser(User userDetails) throws UserNotFoundException {
//		log.info("START");
//		if (getAll().contains(userDetails))
//			userRepository.save(userDetails);
//		else
//			throw new UserNotFoundException(userDetails.getId());
//		log.info("STOP");
//		return "SUCCESS";
		log.info("START");
//		List<User> list = userRepository.findAll();
//		for (User user : list) {
//			if (user.getId() == userDetails.getId()) {
//				user.setName(userDetails.getName());
//				user.setEmail(userDetails.getEmail());
//				user.setPassword(userDetails.getPassword());
//				userRepository.save(user);
//				log.info("STOP");
//				return "Success";
//			} 
//		}
//		throw new UserNotFoundException(userDetails.getId());
		User user=userRepository.findById(userDetails.getId()).orElseThrow(()->new UserNotFoundException(userDetails.getId()));
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		userRepository.save(user);
		log.info("STOP");
		return "Success";
		//return "User Not Found";
	}

	@Override
	public String deleteUser(int id)  {
		log.info("START");
		List<User> list = userRepository.findAll();
		for (User user : list) {
			if (user.getId() == id) {
				userRepository.delete(user);
				log.info("STOP");
				return "Success";
			} 
		}
		return "User Not Found";
//		User user=userRepository.findById(id).get();
//		userRepository.delete(user);
	}
}
