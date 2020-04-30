package com.productregister.dao;

import java.util.List;

import com.productregister.api.Product;

public interface ProductDAO {
	
	public int addProduct(Product product);
	
	public List<Product> getProducts();
	
	}

