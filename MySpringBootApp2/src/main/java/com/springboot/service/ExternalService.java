package com.springboot.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

	@Autowired
	private RestTemplate restTemplate;

	// get all the products
	public List<Object> getProducts() {

		String url = "http://localhost:8090/products";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);

	}
}
