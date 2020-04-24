package com.productregister.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productregister.api.UserRegistrationDTO;

@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO dto) {

		return "user-registration-page";
	}

	@RequestMapping("/registration-success")
	public String processUserRegistration(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto,
			BindingResult result) {

		// binding result should come after UserRegistrationDTO and @Valid should be
		// before @ModelAttribute
		/**if the form has errors, then it will redirect to the same current page  */
		if (result.hasErrors()) {

			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			return "user-registration-page";
		}
		return "registration-success";
	}

}
