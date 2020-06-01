package com.myspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppConfig {
	
	//this is to tell spring security that no password encoding is required
	@Bean
	public PasswordEncoder getPasswordEncorder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
 