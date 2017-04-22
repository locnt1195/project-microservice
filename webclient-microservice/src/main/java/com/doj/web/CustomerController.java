//package com.doj.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CustomerController {
//
//	@Autowired
//	CustomerRepository customerRepository;
//	
//	@RequestMapping("/customerList")
//	public String customerList(Model model){
//		System.out.print("----------------customerList-------");
//		System.out.print(customerRepository.getallCustomers());
//		model.addAttribute("customers", customerRepository.getallCustomers());
//		return "customerList";
//	}
//}
