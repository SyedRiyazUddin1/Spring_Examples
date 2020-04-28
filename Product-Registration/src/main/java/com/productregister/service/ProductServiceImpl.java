package com.productregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productregister.api.Product;
import com.productregister.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO; 

	public void addProduct(Product product) {
		
		calculateFinalPriceWithTax (product);
		
		//calling the DAO layer

		productDAO.addProduct(product);
	}
	
	public void calculateFinalPriceWithTax(Product product) {
		
		
		double tax= product.getPrice()*2%100;
		double finalPrice= product.getPrice()+ tax;
		product.setTax(tax);
		product.setFinalPrice(finalPrice);
	}

}
