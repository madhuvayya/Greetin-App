package com.bridgelabz.greetingapp.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.dto.Greeting;
import com.bridgelabz.greetingapp.dto.User;
import com.bridgelabz.greetingapp.service.GreetingService;

@RestController
public class GreetingController {

	private static final String template="Hello, %s!";
	private final AtomicLong counter= new AtomicLong();
	
	@Autowired
	private GreetingService greetingService;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/message")
	public String greeting() {
		return greetingService.greet(); 
	}
	
	@PostMapping("/greeting")
	public String greetWithUserName(@RequestBody User user) {
		return greetingService.getHelloMessage()+" " + user.getFirstName() + " "+ user.getLastName();
	}
}
