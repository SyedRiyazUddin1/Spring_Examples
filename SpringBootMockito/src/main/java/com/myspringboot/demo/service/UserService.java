package com.myspringboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringboot.demo.dao.UserRepository;
import com.myspringboot.demo.model.User;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		System.out.println("Getting data from DB : " + users);
		return users;
	}

	public List<User> getUserbyAddress(String address) {
		return userRepository.findByAddress(address);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
