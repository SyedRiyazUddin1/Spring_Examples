package com.myspringboot.demo.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspringboot.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	List<User> findByAddress(String address);

}
