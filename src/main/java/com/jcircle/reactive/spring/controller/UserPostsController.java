package com.jcircle.reactive.spring.controller;

import com.jcircle.reactive.spring.model.Post;
import com.jcircle.reactive.spring.model.User;
import com.jcircle.reactive.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class UserPostsController {

    @Autowired
    UserService userService;

    /**
     * Hybrid - Converted the Blocked State call to Streamed call in case of more records......
     * @param userId
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/posts/{userId}" , produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Post> getUserPosts(@PathVariable("userId") final String userId) {

        System.out.println("------In getUserPosts----"+userId);

        List<Post> postList = userService.getPostsByUserId(userId);

        return Flux.fromIterable(postList).delayElements(Duration.ofSeconds(3)).log();



    }


    /**
     * Hybrid - Converted the Blocked State call to Streamed call in case of more records......
     * @param postId
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/post/{postId}" , produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Post> getPostInfo(@PathVariable("postId") final String postId) {

        System.out.println("------In getUserPosts----"+postId);

        Flux<Post> postInfoObj = userService.getPostInfo(postId);

        return postInfoObj.log();



    }



}
