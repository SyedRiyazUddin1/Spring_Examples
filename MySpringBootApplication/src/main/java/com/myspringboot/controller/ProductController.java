package com.myspringboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspringboot.model.Product;
import com.myspringboot.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;

	
	//gets all the products
	@RequestMapping("/products")
	public List<Product> getAllProducts() {

		return productService.getAllProducts();
	}
	
	//fetch the product by id
	@RequestMapping("/products/{id}")
	public  Product getProduct(@PathVariable String id) {
		
		return productService.getProductById(id);
		 
	}
	
	//add a product
	@RequestMapping(method= RequestMethod.POST, value="/products")
	public void addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);
	
	}
	
	//update the product
	@RequestMapping(method= RequestMethod.PUT, value="/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id) {
		
		productService.updateProduct(product);
	
	}
	
	//deletes the product
	@RequestMapping(method= RequestMethod.DELETE, value="/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		
		productService.deleteProduct(id);
		 
	}

}
