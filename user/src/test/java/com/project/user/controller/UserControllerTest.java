package com.project.user.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.user.model.User;
import com.project.user.service.UserService;

@WebMvcTest(controllers = UserController.class)
@ActiveProfiles("test")
class UserControllerTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userDao;

	private List<User> userList;

	@BeforeEach
	void setUp() {
		this.userList = new ArrayList<>();
		this.userList.add(new User(1, "A", "user1@gmail.com", "pwd1"));
		this.userList.add(new User(2, "B", "user2@gmail.com", "pwd2"));
		this.userList.add(new User(3, "C", "user3@gmail.com", "pwd3"));
	}

	@Test
	void shouldFtchAllUsers() throws Exception {
		
//		List<User> list=new ArrayList<>();
//		list.add(new User(1, "A", "user1@gmail.com", "pwd1"));

		when(userDao.getAll()).thenReturn(userList);

		this.mockMvc.perform(get("/user/displayusers")).equals(userList);
	}

	@Test
	void shouldFetchOneUserById() throws Exception {
		final int userId = 1;
		final User user = new User(1, "A", "user1@gmail.com", "pwd1");

		when(userDao.find(userId)).thenReturn(user);

		mockMvc.perform(get("/diplayusers/1")).equals(user);

	}
	
	@Test
	void addUserTest() throws Exception{
		User user=new User(1, "A", "user1@gmail.com", "pwd1");
		when(userDao.addUser(user)).thenReturn("User Added");
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(user);
		mockMvc.perform(post("/user/add").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());

	}
	
	@Test
	void updateUserTest()throws Exception{
		User user=new User(1, "A", "user1@gmail.com", "pwd1");
		when(userDao.updateUser(user)).thenReturn("User Updated");
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(user);
		mockMvc.perform(put("/user/update").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
	}
	
	@Test
	void deleteGameProductTest()throws Exception{
		when(userDao.deleteUser(101)).thenReturn("User deleted successfully...");
		mockMvc.perform(delete("/user/delete/101")).andExpect(status().isOk());
	}
	
	
	
	

}
