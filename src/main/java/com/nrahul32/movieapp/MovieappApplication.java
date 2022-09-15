package com.nrahul32.movieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		// SpringApplication.run returns ApplicationContext object
		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

		// myService bean is created only in qa profile
		System.out.println("Total beans: " + context.getBeanDefinitionCount());
		System.out.println("myService bean created: " + Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("myService"));
	}

	// This will be hit on navigating to http://localhost:8080/
	@RequestMapping(value = "/")
	public String HelloWorld(){
		return "Hello world!";
	}

}
