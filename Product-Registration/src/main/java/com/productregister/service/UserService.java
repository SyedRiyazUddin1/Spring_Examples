package com.productregister.service;

import com.productregister.model.Login;
import com.productregister.model.User;

public interface UserService {
	
	public void register(User user);

	public User validateUser(Login login);

}
