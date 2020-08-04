package com.myspringboot.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("english")
public class HelloWorldServiceEnglishImpl implements HelloWorldService {

	@Override
	public String greeting() {

		return "Hello World!!!";
	}

}
