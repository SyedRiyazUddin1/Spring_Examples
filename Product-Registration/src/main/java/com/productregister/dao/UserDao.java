package com.productregister.dao;

import com.productregister.model.Login;
import com.productregister.model.User;

public interface UserDao {

	void register(User user);

	User validateUser(Login login);

}
