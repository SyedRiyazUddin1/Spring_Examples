package com.myspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myspringboot.service.JwtUserDetailsService;

@Configuration
public class AppConfig {
	
	//this is to tell spring security that no password encoding is required
//	@Bean
//	public PasswordEncoder getPasswordEncorder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	JwtUserDetailsService getJwtUserDetailsService() {
		
		return new JwtUserDetailsService();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


}
 