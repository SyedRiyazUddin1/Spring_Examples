package com.myspringboot.dao;

import java.util.List;

import com.myspringboot.model.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	Product getProductById(String id);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(String id);

}
