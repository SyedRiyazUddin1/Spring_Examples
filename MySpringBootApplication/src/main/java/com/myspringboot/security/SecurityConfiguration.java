package com.myspringboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//class for JDBC authentication configuration using MySQL DB

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		// Setting up the JDBC configuration on the auth object
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username, password, enabled "
		        + "from users "
				+"where username = ?")
		.authoritiesByUsernameQuery("select username, role "
				+ "from authorities "
				+ "where username= ?");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() // authorize all requests

				.antMatchers("/myapp/viewProducts-page/**").hasRole("USER")
				.antMatchers("/myapp/viewWithoutEdit").hasAnyRole("USER", "ADMIN")
				.antMatchers("/").permitAll().and().formLogin();

	}

}
