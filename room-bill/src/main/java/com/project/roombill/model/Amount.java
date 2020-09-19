package com.project.roombill.model;

import lombok.Data;

@Data
public class Amount {
	
	public Amount() {
		super();
	}

	public Amount(int amount) {
		super();
		this.amount = amount;
	}

	private int amount;

}
