package com.myspringboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.myspringboot.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

	// 2nd generic type above should be the type of id

}
