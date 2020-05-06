package com.productregister.dao;

import java.util.List;

import com.productregister.model.Product;

public interface ProductDAO {

	public int addProduct(Product product);

	public List<Product> getProducts();

	public int editProduct(Product product);
	
	public Product getProductById(int id);

	public int deleteProduct(int productId);

}
