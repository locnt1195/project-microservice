package com.example.discovert;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONObject;



@RestController
public class CustomerController {

	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/customers")
	public Customer[] all(){
		logger.info("customsers-microservice all() invoked");
		List<Customer> customer = customerRepository.getAllCustomers();
		logger.info("customers-microservice all() found: " + customer.size());
		
		JSONObject obj = new JSONObject();
		
		
		return customer.toArray(new Customer[customer.size()]);
	}
	
	@RequestMapping("/customers/{id}")
	public Customer byId(@PathVariable("id") String id) {
		logger.info("accounts-microservice byId() invoked: " + id);
		Customer customer = customerRepository.getCustomerbyId(id);
		logger.info("customers-microservice byId() found: " + customer);
		return customer;
	}
}
