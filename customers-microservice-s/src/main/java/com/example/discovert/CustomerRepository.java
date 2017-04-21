package com.example.discovert;

import java.util.List;

public interface CustomerRepository {

	List<Customer> getAllCustomers();
	Customer getCustomerbyId(String id);
}
