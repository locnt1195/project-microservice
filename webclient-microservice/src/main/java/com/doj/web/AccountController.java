/**
 * 
 */
package com.doj.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class AccountController {
	
	protected Logger logger = Logger
			.getLogger(AccountController.class.getName());
	
	@Autowired
	AccountRepository accountRepository;
	

	@RequestMapping("/accountList")
	public String accountList(Model model) {
		logger.info("Acount List");
		model.addAttribute("accounts", accountRepository.getAllAccounts());
		return "accountList";
	}
	
	@RequestMapping("/accountDetails")
	public String accountDetails(@RequestParam("number") String id, Model model) {
		logger.info("Account Detail:" + id);
		model.addAttribute("account", accountRepository.getAccount(id));
		return "accountDetails";
	}
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/customerList")
	public String customerList(Model model){
		logger.info("Customer List");
		model.addAttribute("customers", customerRepository.getallCustomers());
		return "customerList";
	}
	
	@RequestMapping("/test")
	public String test(){
		logger.info("-----test");
		return "Hello";
	}
}
