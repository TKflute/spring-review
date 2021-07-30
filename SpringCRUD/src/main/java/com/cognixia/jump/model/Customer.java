package com.cognixia.jump.model;

import java.time.LocalDate;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate orderDate;
	private String itemCode;
	
	public Customer() {
		this(-1, "N/A", "N/A", LocalDate.now(), "N/A");
	}

	public Customer(int id, String firstName, String lastName, LocalDate orderDate, String itemCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.orderDate = orderDate;
		this.itemCode = itemCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	
}
