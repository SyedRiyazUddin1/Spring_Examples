package com.myspringboot.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet row, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(row.getString("id"));
		product.setName(row.getString("name"));
		product.setDescription(row.getString("description"));
		return product;
	}
}