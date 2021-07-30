package com.cognixia.jump.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Customer;

@Service
public class CustomerService {

	// create an array as mock DB 
	private static List<Customer> customerDB = new ArrayList<>();
	private static int idCounter = 1;
	
	static {
		customerDB.add(new Customer(idCounter++, "Bob", "Smith", LocalDate.of(2021, 10, 10), "MS1"));
		customerDB.add(new Customer(idCounter++, "Sue", "Martin", LocalDate.of(2021, 10, 11), "LS1"));
		customerDB.add(new Customer(idCounter++, "Harry", "Jones", LocalDate.of(2021, 12, 5), "MP2"));
		customerDB.add(new Customer(idCounter++, "Betty", "Franklin", LocalDate.of(2021, 10, 10), "LP1"));
		customerDB.add(new Customer(idCounter++, "James", "Wilson", LocalDate.of(2021, 10, 10), "MP1"));
		customerDB.add(new Customer(idCounter++, "Nancy", "Williams", LocalDate.of(2021, 7, 15), "LS2"));
	}
	
	public List<Customer> getAllCustomers() {
		return customerDB;
	}
	
	public Customer getCustomerById(int id) {
		for(int i = 0; i < customerDB.size(); i++) {
			if(customerDB.get(i).getId() == id) {
				return customerDB.get(i);
			}
		}
		return new Customer();
	}
	
	public Customer deleteCustomerById(int id) {
		
		Customer customerToDelete = getCustomerById(id);
		customerDB.remove(customerToDelete);
		
		return customerToDelete;
	}
	
	public Customer updateCustomer(Customer customer) {
		
		Customer customerToUpdate = getCustomerById(customer.getId());
		
		if(customerToUpdate.getId() != -1) {
			customerToUpdate.setFirstName(customer.getFirstName());
			customerToUpdate.setLastName(customer.getLastName());
			customerToUpdate.setOrderDate(customer.getOrderDate());
			customerToUpdate.setItemCode(customer.getItemCode());
		}
		
		return customerToUpdate;
	}
	
	public Customer addCustomer(String firstName, String lastName, LocalDate orderDate, String itemCode) {
		
		Customer newCustomer = new Customer(idCounter, firstName, lastName, orderDate, itemCode);
		customerDB.add(newCustomer);
		return newCustomer;
	}
}
