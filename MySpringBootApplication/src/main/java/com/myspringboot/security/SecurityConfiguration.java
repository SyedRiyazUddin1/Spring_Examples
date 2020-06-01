package com.myspringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//class for JPA authentication configuration using H2 database

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Setting up the configuration on the auth object
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()  //authorize all requests
		
		.antMatchers("/myapp/viewProducts-page/**").hasRole("User1") 
		.antMatchers("/myapp/viewWithoutEdit").hasAnyRole("User1","User2")
		.antMatchers("/").permitAll()
		.and().formLogin();
		
	}
	
	
//moved this to Appconfig class
//	@Bean
//	public PasswordEncoder getPasswordEncorder() {
//
//		return NoOpPasswordEncoder.getInstance();
//	}

}
