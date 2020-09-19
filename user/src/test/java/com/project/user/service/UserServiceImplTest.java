package com.project.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

import com.project.user.exception.UserNotFoundException;
import com.project.user.model.User;
import com.project.user.resources.UserRepository;

@SpringBootTest
class UserServiceImplTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
//	@MockBean
//	private GameProductRepository gameRepository;
	
	
	@Test
	void testGetUserList() {
		User user = new User(1,"nisha","abc@gmail.com","nisha123");
		List<User> list = new ArrayList<User>();
		list.add(user);
		when(userRepository.findAll()).thenReturn(list);
		assertEquals(list, userService.getAll());
	}
	
	@Test
	void testAddUser() {
		User user=new User(1,"nisha","abc@gmail.com","nisha123");
		when(userRepository.findById(1)).thenReturn(Optional.empty());
		when(userRepository.save(user)).thenReturn(user);
		assertEquals("SUCCESS", userService.addUser(user));
	}
	
	@Test
	void testUpdateUser() throws UserNotFoundException {
		User user = new User(1,"nisha","abc@gmail.com","nisha123");
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		when(userRepository.save(user)).thenReturn(user);
		assertEquals("Success", userService.updateUser(user));
	}
	
	@Test
	void testDeleteUser() {
		User user = new User(1,"nisha","abc@gmail.com","nisha123");
		List<User> list = new ArrayList<User>();
		list.add(user);
		when(userRepository.findAll()).thenReturn(list);
		userService.deleteUser(1);
		verify(userRepository,times(1)).delete(user);
	}
	
	@Test
	void testUserById() {
		User user = new User(1,"nisha","abc@gmail.com","nisha123");
//		List<User> list = new ArrayList<User>();
//		list.add(user);
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		assertEquals(user, userService.find(1));
		
	}


}
