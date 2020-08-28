package com.myspringboot;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myspringboot.dao.Student;
import com.myspringboot.repository.StudentRepository;

@SpringBootApplication
public class SpringbootHibernateJpa1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateJpa1Application.class, args);
	}
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Student id 10001 -> {}", repository.findById(10001L));
		
		logger.info("All users 1 -> {}", repository.findAll());
		
//		//Insert
//		logger.info("Inserting -> {}", repository.save(new Student("John", "A1234657")));
//
//		//Update
//		logger.info("Update 10001 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));
//
//		repository.deleteById(10002L);
		
		logger.info("All users 2 -> {}", repository.findAll());
		
	}

}
