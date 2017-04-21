package com.example.discovert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class StubCustomerRepository implements CustomerRepository {

	private Map<String, Customer> customerById = new HashMap<String, Customer>();
	
	public StubCustomerRepository() {
		// TODO Auto-generated constructor stub
		Customer cus = new Customer((long) 1, "Loc", "male", "111");
		customerById.put("1", cus);
		cus = new Customer((long) 2, "Dat", "female", "112");
		customerById.put("2", cus);
		cus = new Customer((long) 3, "Nguyen", "male", "113");
		customerById.put("3", cus);
		Logger.getLogger(StubCustomerRepository.class).info("Create StubCustomerRepository");
		
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return new ArrayList<Customer>(customerById.values());
	}

	@Override
	public Customer getCustomerbyId(String id) {
		// TODO Auto-generated method stub
		return customerById.get(id);
	}
	
}
