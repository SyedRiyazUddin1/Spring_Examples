package com.myspringboot.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	//gets all the products
	@RequestMapping("/products")
	public List<Product> getAllProducts() {

		return productService.getAllProducts();
	}
	
	//fetch the product by id
	@RequestMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable String id) {
		
		return productService.getProduct(id);
		 
	}
	
	//add a product
	@RequestMapping(method= RequestMethod.POST, value="/products")
	public void addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);
	
	}
	
	//update the product
	@RequestMapping(method= RequestMethod.PUT, value="/products/{id}")
	public void updateProduct(@RequestBody Product topic, @PathVariable String id) {
		
		productService.updateProduct(id,topic);
	
	}
	
	//deletes the product
	@RequestMapping(method= RequestMethod.DELETE, value="/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		
		productService.deleteProduct(id);
		 
	}

}
