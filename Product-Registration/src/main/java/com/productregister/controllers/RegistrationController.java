package com.productregister.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productregister.api.Product;
import com.productregister.service.ProductService;

@Controller
public class RegistrationController {

	@Autowired
	ProductService productService;

	@RequestMapping("/register")
	public String addProduct(@ModelAttribute("userReg") Product product) {

		return "addProduct-page";
	}

	@RequestMapping("/registration-success")
	public String processUserRegistration(@ModelAttribute("userReg") Product product) {

		productService.addProduct(product);

		return "registration-success";
	}

//	@RequestMapping("/viewProducts-page")
//	public String viewProducts(@ModelAttribute("userReg") Product product) {
//
//		productService.getProducts();
//
//		return "viewProducts-page";
//	}

	@RequestMapping("/viewProducts-page")
	public String viewProducts(Model model) {
		List<Product> list = productService.getProducts();
		model.addAttribute("list", list);
		return "viewProducts-page";

	}
}
