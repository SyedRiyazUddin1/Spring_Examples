package com.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspringboot.model.Product;
import com.springboot.service.ExternalService;

@Controller
@RequestMapping("/myapp")
public class ExternalServiceController {

	@Autowired
	ExternalService externalService;

	// get All products
	@RequestMapping("/products")
	public String getAllProducts(Model model) {
		List<Product> list = externalService.getAllProducts();
		model.addAttribute("list", list);
		return "viewProducts-page";
	}

	// fetch the product by id
	@RequestMapping(value = "/products/{id}")
	public Product getProductById(@PathVariable String id) {
		return externalService.getProductById(id);
	}

	// add a product
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product) {
		externalService.addProduct(product);
	}

	// update the product
	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id) {
		externalService.updateProduct(product);
	}

	// deletes the product
	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		externalService.deleteProduct(id);
	}

}
