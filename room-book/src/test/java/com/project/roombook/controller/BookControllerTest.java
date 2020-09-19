package com.project.roombook.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.project.roombook.model.Book;
import com.project.roombook.model.Room;
import com.project.roombook.service.BookService;

@WebMvcTest(controllers = BookController.class)
@ActiveProfiles("test")
class BookControllerTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookDao;

	private List<Room> roomList;

	@BeforeEach
	void setUp() {
		this.roomList = new ArrayList<>();
		this.roomList.add(new Room(1, "Single", "AC", 1000, "AVL"));
		this.roomList.add(new Room(2, "Singe", "Non-AC", 600, "AVL"));
		this.roomList.add(new Room(3, "Double", "Non-AC", 1000, "AVL"));
	}

	@Test
	void shouldFtchAllRooms() throws Exception {
		when(bookDao.displayRoom()).thenReturn(roomList);

		this.mockMvc.perform(get("/book/displayrooms")).equals(roomList);
	}

	@Test
	void shouldFetchOneRoomById() throws Exception {
		final int roomId = 1;
		final Room room = new Room(1, "Single", "AC", 1000, "AVL");

		when(bookDao.getRoom(roomId)).thenReturn(room);

		mockMvc.perform(get("/book/diplayroom/1")).equals(room);

	}

	@Test
	void bookRoomTest() throws Exception {
		when(bookDao.bookRoom(1, 1)).thenReturn("Room is booked succesfully...");
		mockMvc.perform(put("/book/bookroom/1/1")).andExpect(status().isOk());
	}

	@Test
	void leaveRoomTest() throws Exception {
		when(bookDao.leaveRoom(1, 1)).thenReturn("Room is released succesfully...");
		mockMvc.perform(put("/book/leaveroom/1/1")).andExpect(status().isOk());
	}

	@Test
	void shouldFtchAllBookedRooms() throws Exception {

		List<Book> list = new ArrayList<>();
		list.add(new Book(1, 1, "AC", "Single", 1000));

		when(bookDao.bookedRoom()).thenReturn(list);

		this.mockMvc.perform(get("/book/bookedroom")).equals(list);
	}
	
	@Test
	void shouldFtchAmount() throws Exception {
		when(bookDao.amount(1)).thenReturn(1000);

		this.mockMvc.perform(get("/book/amount/1")).andExpect(status().isOk());
	}
	
	

}
