package com.project.roombill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.roombill.FeignClient.BillServiceClient;
import com.project.roombill.model.Bill;
import com.project.roombill.resources.BillRepository;

@Component
public class BillServiceImpl implements BillService{
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	BillServiceClient billServiceClient;	
	
	@Autowired
	BillRepository billRepository;

	@Override
	public Bill total(int userId) {
		//Amount amount = restTemplate.getForObject("http://localhost:8082/book/amount/" + userId, Amount.class);
		int amount=billServiceClient.amount(userId);
		//Bill bill=new Bill(userId,amount.getAmount());
		Bill bill=new Bill(userId,amount);
		billRepository.save(bill);
		return bill;
	}

	@Override
	public List<Bill> getAll() {
		return billRepository.findAll();
	}

}
