package com.productregister.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.productregister.api.Product;


@Repository
public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	public ProductDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addProduct(Product product) {

		String sql = "INSERT INTO productdetails VALUES(?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { product.getProductName(), product.getProductId(), product.getPrice(), product.getFinalPrice(), product.getCountryName(),
							product.getFeatures(), product.getProductCompany()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
