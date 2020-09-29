package com.myspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/academicLibrary")
public class AcademicLibraryController {

//	@ResponseBody: if we use views, no need to mention this annotation

	@RequestMapping("/headFirstBook")
	// this method will get executed when the client hit "library.com/academicLibrary/biologyBook"
	public String giveBiologyBook() {

//		return "/WEB-INF/view/biologyBook.jsp"; without view resolver
		return "headFirstBook";
	}

}
