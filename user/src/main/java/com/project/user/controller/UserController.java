package com.project.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.exception.UserNotFoundException;
import com.project.user.model.User;
import com.project.user.service.UserService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/user")
public class UserController {
	
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserService userDao;
	
	@GetMapping("/displayusers")
	public List<User> getAll(){
		log.info("START");
		log.info("END");
		return userDao.getAll();
	}
	
	@GetMapping("/displayuser/{id}")
	public User findById(@PathVariable int id) {
		log.info("START");
		log.info("END");
		return userDao.find(id);
		
	}
	
	@PostMapping("/add")
	public String add(@RequestBody User user){
		log.info("START");
		log.info("END");
		return userDao.addUser(user);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody User user) throws UserNotFoundException {
		log.info("START");
		log.info("END");
		return userDao.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		log.info("START");
		log.info("END");
		return userDao.deleteUser(id);
	}
}
