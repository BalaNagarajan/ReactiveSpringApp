package com.jcircle.reactive.spring.controller;

import java.time.Duration;
import java.util.List;

import com.jcircle.reactive.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcircle.reactive.spring.model.User;

import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin
	@GetMapping(value = "/users")
	public List<User> getUserList() {

		System.out.println("------In List----");

         List<User> userList = userService.getCustomerList();
		return userList;

	}

	/**
	 * Browser is blocking one , so the result gets rendered till all the results gets returned - you will see few seconds latency
	 * @return
	 */
	@CrossOrigin
	@GetMapping(value = "/names")
	public Flux<String> returnNames() {
		return Flux.just("James","Philipps","David","Samsung");
	}



	/**
	 * In this one you will see the stream of data one by one...
	 * @return
	 */
	@CrossOrigin
	@GetMapping(value = "/stream/names", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)

	public Flux<String> returnStreamNamesByDelay() {
		return Flux.just("James","Philipps","David","Samsung").delayElements(Duration.ofSeconds(2)).log();
	}


	/**
	 * In this one you will see the stream of data one by one...infinite times
	 * @return
	 */
	@CrossOrigin
	@GetMapping(value = "/stream/infinite/interval", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)

	public Flux<Long> returnStreamNamesByInterval() {
		return Flux.interval(Duration.ofSeconds(2)).log();
	}

}
