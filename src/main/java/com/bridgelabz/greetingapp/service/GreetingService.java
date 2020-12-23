package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	public String greet() {
		return "Hello World";
	}

	public String getHelloMessage() {
		return "Hello";
	}

}
