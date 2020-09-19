package com.project.roombook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	public Book(int user_id, int room_id, String room_type, String room_name, int amount) {
		super();
		this.user_id = user_id;
		this.room_id = room_id;
		this.room_type = room_type;
		this.room_name = room_name;
		this.amount = amount;
	}

//	public Book() {
//		super();
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="room_id")
	private int room_id;
	
	@Column(name="room_type")
	private String room_type;
	
	@Column(name="room_name")
	private String room_name;
	
	@Column(name="amount")
	private int amount;
	
}


