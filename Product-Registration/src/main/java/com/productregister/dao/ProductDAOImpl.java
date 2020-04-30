package com.productregister.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper; 
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import com.productregister.api.Product;

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
							product.getFinalPrice() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Product> getProducts() {
		return jdbcTemplate.query("select * from productdetails", new RowMapper<Product>() {
			
			
			
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product product = new Product();
				
				product.setProductName(rs.getString(1));
				product.setProductId(rs.getInt(2));
				product.setPrice(rs.getDouble(3));
				product.setProductCompany(rs.getString(4));
				product.setCountryName(rs.getString(5));
				product.setFeatures(rs.getString(6));
				product.setFinalPrice(rs.getDouble(7));
				

				return product;
			}
		});
	}
}
