package com.project.roombook.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.roombook.model.User;

@FeignClient(name = "userservice", url = "http://localhost:8086/user")
public interface BookServiceClient {

	@GetMapping("/displayusers")
	public List<User> getAll();
		
	
	@GetMapping("/displayuser/{id}")
	public User findById(@PathVariable int id);
		
}
