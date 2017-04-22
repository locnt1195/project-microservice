package com.doj.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteCustomerRepository implements CustomerRepository {

	@Autowired RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteCustomerRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public List<Customer> getallCustomers() {
		// TODO Auto-generated method stub
		Customer[] customers = restTemplate.getForObject(serviceUrl+"/customers", Customer[].class);
		return Arrays.asList(customers);
	}

	@Override
	public Customer getCustomerById(Long Id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(serviceUrl+"/customers/{id}", Customer.class, Id);
	}

}
