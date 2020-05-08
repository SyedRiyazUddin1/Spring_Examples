package com.productinventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.productinventory.dao.UserDao;
import com.productinventory.model.User;


@Controller
public class UserRegistrationController {

	@Autowired
	//private UserService userService;
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userRegistration(@RequestParam(required=false,name="userId") String userId,
			@RequestParam(required=false,name="password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);

		int counter = userDao.registerUser(user);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("registration");

		return mv;

	}

}
	
