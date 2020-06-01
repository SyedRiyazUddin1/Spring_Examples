package com.myspringboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myspringboot.model.Product;
import com.myspringboot.model.ProductRowMapper;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() {

		String sql = "SELECT id, name, description FROM myproducts";
		// RowMapper<Article> rowMapper = new
		// BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Product> rowMapper = new ProductRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Product getProductById(String id) {

		String sql = "SELECT id, name, description FROM myproducts WHERE id = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		Product product = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return product;
	}

	// Add product
	@Override
	public void addProduct(Product product) {

		String sql = "INSERT INTO myproducts (id, name, description) values (?, ?, ?)";
		jdbcTemplate.update(sql, product.getId(), product.getName(), product.getDescription());

		// Fetch product id
		sql = "SELECT id FROM myproducts WHERE name = ? and description=?";
		String id = jdbcTemplate.queryForObject(sql, String.class, product.getName(), product.getDescription());

		// Set product id
		product.setId(id);

	}

	//update products
	@Override
	public void updateProduct(Product product) {

		String sql = "UPDATE myproducts SET name=?, description=? WHERE id=?";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getId());

	}

	//delete product
	@Override
	public void deleteProduct(String id) {

		String sql = "DELETE FROM myproducts WHERE id=?";
		jdbcTemplate.update(sql, id);

	}

}
