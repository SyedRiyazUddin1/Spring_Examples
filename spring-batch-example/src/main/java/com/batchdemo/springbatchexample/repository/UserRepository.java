package com.batchdemo.springbatchexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batchdemo.springbatchexample.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
