package com.jcircle.reactive.spring.service;

import com.jcircle.reactive.spring.model.Post;
import com.jcircle.reactive.spring.model.User;
import reactor.core.publisher.Flux;

import java.util.List;


public interface UserService {

    public List<User> getCustomerList();
    public User getCustomerInfo(String customerId);
    public List<Post> getPostsByUserId(String userId);
    public Flux<Post> getPostInfo(String postId);


}
