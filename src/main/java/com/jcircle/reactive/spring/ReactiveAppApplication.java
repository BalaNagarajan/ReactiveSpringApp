package com.jcircle.reactive.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ReactiveAppApplication {

	public static void main(String[] args) {
		System.out.println("----In main-----");
		SpringApplication.run(ReactiveAppApplication.class, args);
	}

}
