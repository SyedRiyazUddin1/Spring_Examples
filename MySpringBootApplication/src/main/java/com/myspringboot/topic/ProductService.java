package com.myspringboot.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	//gets all the products
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();
		productRepository.findAll()
		.forEach(products::add);

		return products;
	}
	
	//fetch the product by id
	public Optional<Product> getProduct(String id) {
		return productRepository.findById(id);

	}

	//add a product
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	//update the product
	public void updateProduct(String id, Product product) {
		productRepository.save(product);

	}

	//deletes the product
	public void deleteProduct(String id) {
		productRepository.deleteById(id);

	}

}
