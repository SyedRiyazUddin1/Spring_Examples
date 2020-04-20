package com.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // similar to @Component annotation
public class MomController {

	@ResponseBody // this annotation helps in giving the response back 
	//with the message returned by the below method	
	
	@RequestMapping("/sugar")
	//this method will get executed when the client hit "home.com/sugar"
	public String giveSugar() {
		return "Ok..Here's your Sugar";
	}

}
