package com.productregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productregister.dao.ProductDAO;
import com.productregister.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;

	public void addProduct(Product product) {

		calculateFinalPriceWithTax(product);

		// calling the DAO layer

		productDAO.addProduct(product);
	}

	//adding the tax to the price
	public void calculateFinalPriceWithTax(Product product) {

		double tax = product.getPrice() * 2 / 100;
		double finalPrice = product.getPrice() + tax;
		product.setTax(tax);
		product.setFinalPrice(finalPrice);
	}

	@Override
	public List<Product> getProducts() {
		
	return productDAO.getProducts();
	}

	@Override
	public int editProduct(Product product) {
		
		return productDAO.editProduct(product);
	}

	@Override
	public Product getProductById(int id) {
		
		return productDAO.getProductById(id);
	}

	@Override
	public int deleteProduct(int productId) {
		
		return productDAO.deleteProduct(productId);
	}



}
