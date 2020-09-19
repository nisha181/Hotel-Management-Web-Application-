package com.project.roombook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class User {
	
	@NotNull(message = "Id can not be null")
	private int id;
	
	
	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters long")
	private String name;
	
	
	@NotNull(message = "email can not be null")
	@NotEmpty(message = "email may not be empty")
	@Email
	private String email;
    
	
	@NotNull(message = "Password can not be null")
	@Length(min = 8, max = 12)
	private String password;

}

