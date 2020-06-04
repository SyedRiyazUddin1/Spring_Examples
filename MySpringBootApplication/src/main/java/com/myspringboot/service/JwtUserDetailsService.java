package com.myspringboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myspringboot.dao.UserDAO;
import com.myspringboot.dao.UserDAOImpl;
import com.myspringboot.model.UserDTO;


public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAOImpl userDaoImpl;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("Riyaz".equals(username)) {
			return new User("Riyaz", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	public UserDAO save(UserDTO user) {
		UserDAO newUser = new UserDAO();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDaoImpl.save(newUser);
	}

}
