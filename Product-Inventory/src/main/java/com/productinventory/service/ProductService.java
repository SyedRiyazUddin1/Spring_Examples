package com.productinventory.service;

import java.util.List;

import com.productinventory.model.Product;


public interface ProductService {

	public void addProduct(Product product);

	public List<Product> getProducts();

	public int editProduct(Product product);

	public Product getProductById(int id);

	public int deleteProduct(int productId);

}
