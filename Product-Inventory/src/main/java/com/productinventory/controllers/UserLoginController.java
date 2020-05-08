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
public class UserLoginController {

	@Autowired
	private UserDao userDao;
	//private UserService userService;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin(@RequestParam(required=false,name="userId") String userId, @RequestParam(required=false,name="password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);

		String name = userDao.loginUser(user);

		if (name != null) {

			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			mv.setViewName("welcome");

		} else {

			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}

		return mv;

	}

}