package com.myspringboot.topic;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

	// 2nd generic type above should be the type of id

}
