package com.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.service.AddService;

@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int num1, @RequestParam("t2") int num2, HttpServletRequest request,
			HttpServletResponse response) {

		// int num1 = Integer.parseInt(request.getParameter("t1"));
		// int num2 = Integer.parseInt(request.getParameter("t2"));

		AddService as = new AddService();
		int sum = as.add(num1, num2);

		ModelAndView mv = new ModelAndView();
		//mv.setViewName("display.jsp"); //when we use configuration file
		mv.setViewName("display");
		mv.addObject("result", sum);

		return mv;
	}
}
