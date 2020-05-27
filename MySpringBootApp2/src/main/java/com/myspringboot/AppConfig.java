package com.myspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springboot.service.ExternalService;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ExternalService getExternalService() {
		return new ExternalService();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncorder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
