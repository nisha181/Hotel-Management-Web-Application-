package com.project.roombill.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.project.roombill.model.Bill;
import com.project.roombill.service.BillService;

@WebMvcTest(controllers = BillController.class)
@ActiveProfiles("test")
class BillControllerTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BillService billDao;

	private List<Bill> billList;
	
	@BeforeEach
	void setUp() {
		this.billList = new ArrayList<>();
		this.billList.add(new Bill(1, 1000));
		this.billList.add(new Bill(2, 2000));
		this.billList.add(new Bill(3, 2000));
	}
	
	@Test
	void shouldFetchOneBillById() throws Exception {
		final int userId = 1;
		final Bill bill = new Bill(1, 1000);

		when(billDao.total(userId)).thenReturn(bill);

		mockMvc.perform(get("/bill/totalbill/1")).equals(bill);

	}
	
	@Test
	void shouldFtchAllBills() throws Exception {
		when(billDao.getAll()).thenReturn(billList);

		this.mockMvc.perform(get("/bill/billlist")).equals(billList);
	}


}
