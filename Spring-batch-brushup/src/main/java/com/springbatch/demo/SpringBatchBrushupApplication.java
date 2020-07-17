package com.springbatch.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
/*
 * @EnableBatchProcessing annotation enables Spring Batch features and provide a
 * base configuration for setting up batch jobs in an @Configurationclass,
 * roughly equivalent to using the <batch:*> XML namespace.
 */
public class SpringBatchBrushupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchBrushupApplication.class, args);
	}

}
