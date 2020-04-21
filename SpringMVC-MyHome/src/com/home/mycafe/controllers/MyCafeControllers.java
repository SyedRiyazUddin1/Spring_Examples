package com.home.mycafe.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCafeControllers {

	//Returns the welcome page
	@RequestMapping("/cafe")
	public String showWelcomePage() {

		return "welcome-page";
	}
	
	
	///Returns the order page
	@RequestMapping("processOrder")
	public  String processOrder(HttpServletRequest request, Model model) {
		
		//handling the data received from user
		String userEnteredValue= request.getParameter("foodType");
		
		//adding the  captured value to model
		model.addAttribute("userInput", userEnteredValue);
		 
		 
		//Setting the user data with the model object and sending it to view
		
		
		return "process-order";
		 
	}

}
