package com.productinventory.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.productinventory.model.User;

@Component
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int registerUser(User user) {

		String sql = "INSERT INTO USER_DATA VALUES(?,?)";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { user.getUserId(), user.getPassword() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String loginUser(User user) {

		String sql = "SELECT USER_ID FROM USER_DATA WHERE USER_ID=? AND USER_PASS=?";

		try {

			String userId = jdbcTemplate.queryForObject(sql, new Object[] { user.getUserId(), user.getPassword() },
					String.class);

			return userId;

		} catch (Exception e) {
			return null;
		}
	}

}
