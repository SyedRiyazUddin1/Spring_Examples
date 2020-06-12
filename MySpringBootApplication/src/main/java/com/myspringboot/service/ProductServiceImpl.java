package com.myspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringboot.dao.ProductDao;
import com.myspringboot.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	// gets all the products.
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	// fetch the product by id
	@Override
	public Product getProductById(String id) {
		Product product = productDao.getProductById(id);
		return product;
	}

	// add a product
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	
	// update the product
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);

	}

	// deletes the product
	@Override
	public void deleteProduct(String id) {
		productDao.deleteProduct(id);

	}

}
