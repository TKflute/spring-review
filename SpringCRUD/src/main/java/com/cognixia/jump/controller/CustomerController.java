package com.cognixia.jump.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.service.CustomerService;

@RequestMapping("/api")
@RestController
public class CustomerController {

		// this annotation will create instance of class for our service
		@Autowired
		CustomerService service;
		
		// endpoint: localhost:8080/api/customers
		@GetMapping("/customers")
		public List<Customer> getAllCustomers(){
			return service.getAllCustomers();
		}
		
		@GetMapping("/customers/{id}")
		public Customer getCustomer(@PathVariable String id){
			int customerId = Integer.parseInt(id);
			return service.getCustomerById(customerId);
		}
		
		
		@DeleteMapping("/deletecustomer/{id}")
		public void deleteCustomer(@PathVariable int id) {
			
			Customer deleted = service.deleteCustomerById(id);
			System.out.println("Customer deleted: " + deleted);
		}
		
		@PutMapping("/updatecustomer")
		public void updateCustomer(@RequestBody Customer customer) {
			
			Customer updated = service.updateCustomer(customer);
			System.out.println("Customer updated: " + updated);
		}
		
		@PostMapping("/addcustomer")
		public void addCustomer(@RequestBody Customer customer) {
			
			Customer added = service.addCustomer(customer.getFirstName(), customer.getLastName(), customer.getOrderDate(), customer.getItemCode());
			System.out.println("New customer: " + added);
		}
		
		// note the ServletUriComponentsBuilder- review this
		@PostMapping("/addcustomer2")
		public ResponseEntity<String> addCustomer2(@RequestBody Customer customer) {
			
			Customer newCustomer = service.addCustomer(customer.getFirstName(), customer.getLastName(), 
					customer.getOrderDate(), customer.getItemCode());
			
			System.out.println("New Customer: " + newCustomer);
			
			// URI is like a url, this is the url we are using to indicate where this new
			// customer can be found doing a get request using their newly created customer
			// id number
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newCustomer.getId())
					.toUri();

			// the response given will give back the customer's id in the header and
			// their full name in the body
			return ResponseEntity.created(location)
					.header("customer", newCustomer.getId() + "")
					.body(newCustomer.getFirstName() + " " + newCustomer.getLastName());
		}
		
}
