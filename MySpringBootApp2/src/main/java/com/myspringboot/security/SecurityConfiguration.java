package com.myspringboot.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//class for in-memory authentication configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Setting up the configuration on the auth object
		auth.inMemoryAuthentication()
		.withUser("Riyaz")
		.password("nisum123")
		.roles("User1")
		.and()
	
		//configuring multiple user authentication
		.withUser("Syed")
		.password("nisum111")
		.roles("User2");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/**").hasRole("User1")
		.antMatchers("/myapp/viewWithoutEdit").hasAnyRole("User1","User2")
		.and()
		.formLogin();
		
	}
	
	
//moved this to Appconfig class
//	@Bean
//	public PasswordEncoder getPasswordEncorder() {
//
//		return NoOpPasswordEncoder.getInstance();
//	}

}
