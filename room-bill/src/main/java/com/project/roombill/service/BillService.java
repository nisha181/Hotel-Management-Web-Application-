package com.project.roombill.service;

import java.util.List;

import com.project.roombill.model.Bill;

public interface BillService {
	
	public Bill total(int userId);
	public List<Bill> getAll();

}
