package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Books;


public interface BooksRepository extends CrudRepository<Books, Integer> {
}
