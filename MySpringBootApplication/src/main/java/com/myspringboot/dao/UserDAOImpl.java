package com.myspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspringboot.dao.UserDAO;

/**
 * CrudRepository class is a generics and takes the following two parameters as
 * arguments- What type of Object will this repository be working with- In our
 * case UserDAO and Id will be what type of object- Integer
 * (since id defined in the UserDao class is Integer)
 */
@Repository
public interface UserDAOImpl extends CrudRepository<UserDAO, Integer> {
}
