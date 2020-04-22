package com.springmvc.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage() {

		return "home-page";
	}

	@RequestMapping("/process-homepage")

	public String showResultPage(@RequestParam("userName") String userName1,
			@RequestParam("crushName") String crushName1, Model model) {

		System.out.println("user Name is :" + userName1);
		System.out.println("crush Name is :" + crushName1);
		
		model.addAttribute("userName", userName1);
		model.addAttribute("crushName", crushName1);

		return "result-page";
	}
}
