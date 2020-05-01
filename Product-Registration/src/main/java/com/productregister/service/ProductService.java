package com.productregister.service;


import java.util.List;

import com.productregister.api.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	public List<Product> getProducts();
	
	
	public int editProduct(Product product);
	public Product getProductById(int id);
	
	
	//public int saveOrUpdate(Product product);

	

}
