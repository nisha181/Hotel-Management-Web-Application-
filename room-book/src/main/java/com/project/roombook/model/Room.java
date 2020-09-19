package com.project.roombook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	@Id
	@Column(name = "room_id", nullable = false)
	@NotNull(message = "Id can not be null")
	private int room_id;
	
	@Column(name = "room_name")
	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters long")
	private String room_name;
	
	@Column(name="room_type")
	private String room_type;
	
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="availability")
	@NotNull
	private String availability;
}

