package com.myspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvc.model.Employee;

/**
 * 
 * @author riyaz
 * 
 *
 */

@Controller
@RequestMapping(value = "/Employee")
public class EmployeeController {

	/*
	 * This web project can be accessed with the below URL along with name and id
	 * http://localhost:8080/MultipleViewResolversExample/API/Employee/Riyaz/123
	 */
	@RequestMapping(value = "/{name}/{empId}", method = RequestMethod.GET)
	public ModelAndView process(@PathVariable("name") String name, @PathVariable("empId") String empId) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setName(name);
		
     // rendering back the data in JSON format
     //	modelAndView.setViewName("jsonView");
		
		//returning employeeDetails.jsp
		modelAndView.setViewName("employeeDetails");
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}
}