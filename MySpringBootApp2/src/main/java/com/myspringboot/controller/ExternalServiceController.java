package com.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.ExternalService;

@RestController
@RequestMapping("/myapp")
public class ExternalServiceController {

	@Autowired
	ExternalService externalService;
	

	@GetMapping("/products")
	public List<Object> getProducts() {
		return externalService.getProducts();
		
	}

}

