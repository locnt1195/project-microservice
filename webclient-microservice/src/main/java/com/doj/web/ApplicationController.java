package com.doj.web;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
	
	protected Logger logger = Logger
			.getLogger(AccountController.class.getName());
	
	@RequestMapping("/")
	public String home(){
		logger.info("Index");
		return "index";
	}
}
