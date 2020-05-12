package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {

		SpringApplication.run(CourseApiApp.class, args);

		/**
		 * When the above line gets executed, It sets up default configuration, It starts
		 * Spring application context, It performs class path scan, It starts Tomcat-Server
		 */

	}

}
