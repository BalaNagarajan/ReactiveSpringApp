package com.jcircle.reactive.spring.service;

import com.jcircle.reactive.spring.model.Post;
import com.jcircle.reactive.spring.model.User;
import com.jcircle.reactive.spring.response.PostResponse;
import com.jcircle.reactive.spring.util.RestUtilFactory;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    RestUtilFactory restUtilFactory;

    @Override
    public List<User> getCustomerList() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setUserId("1");
        user.setUserAddress("34 Cross Street wels IL");
        user.setUserName("David Nicole");
        user.setPremiumUser(true);
        userList.add(user);
        user = new User();

        user.setUserId("2");
        user.setUserAddress("34 Frank St Dons, CA");
        user.setUserName("Mark Pike");
        user.setPremiumUser(true);
        userList.add(user);

        return userList;
    }

    @Override
    public User getCustomerInfo(String customerId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUserId(String userId) {
        System.out.println("User ID In Service0-----"+userId);
        List<Post> postList = null;

        /**
         * For Blocking IO - please use the REST Template --- Starts
         */
       RestTemplate restTemplate = restUtilFactory.getRestTemplate();
        ResponseEntity<List<Post>> postResponse =
                restTemplate.exchange("https://jsonplaceholder.typicode.com/posts?userId="+userId,
                       HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
                        });
       if(postResponse != null) {
             postList = postResponse.getBody();
            postList.forEach(postObj -> {
                System.out.println(postObj.getTitle());
            });
        }
        else{
            System.out.println("-----List is empty");
        }

        System.out.println("-----Processing Completed ---");

        return postList;
    }

    public Flux<Post> getPostInfo(String postId) {

        Flux<Post> postObj = null;

        WebClient webClient = restUtilFactory.getWebClient();
        //Performing Async Call
        postObj = webClient.get().uri("https://jsonplaceholder.typicode.com/posts/"+postId).retrieve().bodyToFlux(Post.class).delayElements(Duration.ofSeconds(3));
        //postObj.filter(s -> !s.getTitle().equalsIgnoreCase("Bala")).filter(webClient.get().uri("https://jsonplaceholder.typicode.com/posts/2").retrieve().bodyToFlux(Post.class)).log();
        System.out.println("Performing other DB call");
        return postObj;

    }
}
