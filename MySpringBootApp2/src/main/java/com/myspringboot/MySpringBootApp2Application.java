package com.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.springboot.service.ExternalService;

@SpringBootApplication
public class MySpringBootApp2Application {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ExternalService getExternalService() {
		return new ExternalService();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApp2Application.class, args);
	}

}
