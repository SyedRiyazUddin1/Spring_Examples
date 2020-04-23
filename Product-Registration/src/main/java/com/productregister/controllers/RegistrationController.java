package com.productregister.controllers;


	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.productregister.api.UserRegistrationDTO;

	@Controller
	public class RegistrationController {
		
		@RequestMapping("/register")
		public String showRegistrationPage(@ModelAttribute("userReg")UserRegistrationDTO dto) {
		
			return "user-registration-page";
		}
		
		@RequestMapping("/registration-success")
		public String processUserRegistration(@ModelAttribute("userReg")UserRegistrationDTO dto) {
			
			return "registration-success";
		}
			

	}

