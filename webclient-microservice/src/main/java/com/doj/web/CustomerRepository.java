package com.doj.web;

import java.util.List;

public interface CustomerRepository {
	
	List<Customer> getallCustomers();
	
	Customer getCustomerById(Long Id);
}
