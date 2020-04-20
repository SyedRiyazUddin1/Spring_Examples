package com.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BroController {

//	@ResponseBody if we use views, no need to mention this annotation

	@RequestMapping("/cricketBat")
	// this method will get executed when the client hit "home.com/cricketBat"
	public String giveCricketBat() {

//		return "/WEB-INF/view/MRFcricketBat.jsp"; without view resolver

		return "MRFcricketBat";
	}

}
