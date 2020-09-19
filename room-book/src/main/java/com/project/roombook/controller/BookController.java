package com.project.roombook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.roombook.model.Book;
import com.project.roombook.model.Room;
import com.project.roombook.service.BookService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/book")
public class BookController {

//	@Autowired
//	private RoomRepository roomRepository;
//	
//	@Autowired
//	private BookRepository bookRepository;

	@Autowired
	private BookService bookDao;

	@GetMapping("/displayrooms")
	public List<Room> displayRoom() {
		log.info("START");
		log.info("END");
		return bookDao.displayRoom();
	}

	@GetMapping("/displayroom/{id}")
	public Room getRoom(@PathVariable int id) {
		log.info("START");
		log.info("END");
		return bookDao.getRoom(id);
	}

	@PutMapping("/bookroom/{roomId}/{userId}")
	public String bookRoom(@PathVariable int roomId, @PathVariable int userId) {
		log.info("START");
		log.info("END");
		return bookDao.bookRoom(roomId, userId);
	}

	@PutMapping("/leaveroom/{userId}/{roomId}")
	public String leaveRoom(@PathVariable int userId, @PathVariable int roomId) {
		log.info("START");
		log.info("END");
		return bookDao.leaveRoom(roomId, userId);
	}
	
	@GetMapping("/bookedroom")
	public List<Book> bookedRoom(){
		log.info("START");
		log.info("END");
		return bookDao.bookedRoom();
	}
	
	@GetMapping("/amount/{user_id}")
	public int amount(@PathVariable int user_id) {
		log.info("START");
		log.info("END");
		return bookDao.amount(user_id);
	}

}
