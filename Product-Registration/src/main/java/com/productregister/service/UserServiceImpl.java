package com.productregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productregister.dao.UserDao;
import com.productregister.model.Login;
import com.productregister.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void register(User user) {
		userDao.register(user);

	}

	@Override
	public User validateUser(Login login) {

		return userDao.validateUser(login);
	}

}
