package com.productregister.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;import

com.productregister.api.Product;

@Component
public class ProductDAOImpl implements ProductDAO {

	JdbcTemplate jdbcTemplate;

	public ProductDAOImpl() {
	}

	@Autowired
	public ProductDAOImpl(DriverManagerDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addProduct(Product product) {

		String sql = "INSERT INTO productdetails VALUES(?,?,?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { product.getProductName(), product.getProductId(), product.getPrice(),
							product.getProductCompany(), product.getCountryName(), product.getFeatures(),
							product.getFinalPrice()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
