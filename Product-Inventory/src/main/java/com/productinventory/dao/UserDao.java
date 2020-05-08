package com.productinventory.dao;

import com.productinventory.model.User;

public interface UserDao {
	
	public int registerUser(User user);

	public String loginUser(User user);


}
