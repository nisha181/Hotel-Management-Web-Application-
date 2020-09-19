package com.project.roombill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.roombill.model.Bill;
import com.project.roombill.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	BillService billDao;
	
//	@Autowired
//	BillRepository billRepository;
	
	@GetMapping("/totalbill/{id}")
	public Bill total(@PathVariable int id) {
		return billDao.total(id);
	}
	
	@GetMapping("/billlist")
	public List<Bill> getAll() {
		return billDao.getAll();
	}
	
	

}
