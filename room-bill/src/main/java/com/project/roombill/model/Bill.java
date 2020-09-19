package com.project.roombill.model;

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
@Table(name="bill")
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	
	public Bill(int user_id, int amount) {
		super();
		this.user_id = user_id;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="amount")
	private int amount;
	
	
	
}


