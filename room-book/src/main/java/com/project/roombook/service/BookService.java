package com.project.roombook.service;

import java.util.List;

import com.project.roombook.model.Book;
import com.project.roombook.model.Room;

public interface BookService {
	
	public List<Room> displayRoom();
	public Room getRoom(int id);
	public String bookRoom(int roomId,int userId);
	public String leaveRoom(int roomId,int userId);
	public List<Book> bookedRoom();
	public int amount(int user_id);

}
