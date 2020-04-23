package com.springmvc.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cpm.springmvc.lc.api.UserInfoDTO;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo")UserInfoDTO userInfoDTO) {
		
		//THE BELOW code is replaced my the @ModelAttribute annotation in the showHomePage parenthesis
		//read the existing property by fetching it from dto
//		UserInfoDTO userInfo= new UserInfoDTO();
//		model.addAttribute("userInfo", userInfo);

		return "home-page";
	}

	@RequestMapping("/process-homepage")
//@RequestParam helps us in capturing the query entered by the user
//	public String showResultPage(@RequestParam("userName") String userName1,
//			@RequestParam("crushName") String crushName1, Model model) {

	
	public String showResultPage(@ModelAttribute("userInfo")UserInfoDTO userInfoDTO) {

		
//		//writing the values to the properties by fetching  from the url
	//below code is replaced my the @ModelAttribute annotation in the showHomePage parenthesis
		//model.addAttribute("userInfo", userInfoDTO);
		//model attribute is the latest way of binding data in spring
		
		return "result-page";
	}
}
