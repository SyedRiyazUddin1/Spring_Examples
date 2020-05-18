package com.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.springboot.service.ExternalService;

@SpringBootApplication
public class MySpringBootApp2Application {
	

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApp2Application.class, args);
	}

}
