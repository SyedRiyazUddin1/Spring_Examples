package com.productregister.service;


import java.util.List;

import com.productregister.api.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	public List<Product> getProducts();

	

}
