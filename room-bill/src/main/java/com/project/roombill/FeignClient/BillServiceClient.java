package com.project.roombill.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", url = "http://localhost:8082/book")
public interface BillServiceClient {

	
	@GetMapping("/amount/{user_id}")
	public int amount(@PathVariable int user_id);

}
