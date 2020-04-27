package com.productregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.productregister.dao.ProductDAO;
import com.productregister.dao.ProductDAOImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.productregister.controllers")
public class AppConfig {

	// setting up the ViewResolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// creating the database connection
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}

	// instantiating the ProductDAO
	@Bean
	public ProductDAO getProductDao() {
		return new ProductDAOImpl(getDataSource());
	}

}
