package com.productregister.dao;

import org.springframework.stereotype.Repository;

import com.productregister.api.Product;

@Repository
public interface ProductDAO {
	
	public int addProduct(Product product);
	
	}

