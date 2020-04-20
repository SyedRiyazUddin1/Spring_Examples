package com.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/sis") //request mapping at class level
@Controller
public class SisController {
	
	@ResponseBody
	@RequestMapping("/makeup")
	public String getMakeupKit() {
		return "Take my MakeUp Kit";
	}
	
	
	@ResponseBody
	@RequestMapping("/book")
	public String  getBooks() {
		return "Here is the Math Book";
	}

}
