package com.project.roombook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.roombook.FeignClient.BookServiceClient;
import com.project.roombook.model.Book;
import com.project.roombook.model.Room;
import com.project.roombook.model.User;
import com.project.roombook.resources.BookRepository;
import com.project.roombook.resources.RoomRepository;

import lombok.extern.java.Log;

@Log
@Component
public class BookServiceImpl implements BookService {
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	BookServiceClient bookServiceClient;
	
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	BookRepository bookRepository;

	@Override
	public String bookRoom(int roomId, int userId) {

		//User user = restTemplate.getForObject("http://localhost:8086/user/displayuser/" + userId, User.class);
		User user= bookServiceClient.findById(userId);
		List<Room> list = roomRepository.findAll();
		for (Room room : list) {
			if (room.getRoom_id() == roomId && room.getAvailability().equalsIgnoreCase("available")) {
				room.setAvailability("booked");
				roomRepository.save(room);
				Book book = new Book(user.getId(), room.getRoom_id(), room.getRoom_type(), room.getRoom_name(),
						room.getAmount());
				bookRepository.save(book);
				return "ROOM CONFIRMED";
			}
		}
		return "NOT SUCCESSFUL";

	}

	@Override
	public String leaveRoom(int roomId, int userId) {
		//User user = restTemplate.getForObject("http://localhost:8086/user/displayuser/" + userId, User.class);
		User user= bookServiceClient.findById(userId);
		List<Room> list = roomRepository.findAll();
		List<Book> list1 = bookRepository.findAll();
		for (Room room : list) {
			if (room.getRoom_id() == roomId) {
				if (room.getAvailability().equalsIgnoreCase("booked")) {
					room.setAvailability("available");
					roomRepository.save(room);
					for (Book book : list1) {
						if (book.getRoom_id() == roomId && book.getUser_id() == userId) {
							bookRepository.delete(book);
						}
					}
					return "ROOM RELEASED";

				} else
					return "ROOM IS ALREADY AVAILABLE";
			}
		}
		return "NOT SUCCESSFUL";
	}

	@Override
	public List<Room> displayRoom() {
		log.info("START");
		log.info("END");
		return roomRepository.findAll();
	}

	@Override
	public Room getRoom(int id) {
		log.info("START");
		log.info("END");
		List<Room> list=roomRepository.findAll();
		for (Room room : list) {
			if(room.getRoom_id()==id)
				return room;
		}
		return null;
	}

	@Override
	public List<Book> bookedRoom() {
		log.info("START");
		log.info("END");
		return bookRepository.findAll();
	}

	@Override
	public int amount(int user_id) {
		log.info("START");
		log.info("END");
		return bookRepository.total(user_id);
	}
}
