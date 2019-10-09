package com.jcircle.reactive.spring.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * The purpose of this util class  - factory to return the single instance of RestTemplate or WebClient
 *
 * Author : N.Bala
 *
 *
 *
 *
 */
@Component
public class RestUtilFactory {

    /**
     * For blocking requests
     */
    private RestTemplate restTemplate;

    /**
     * For Non Blocking requests
     * @return
     */
    private WebClient webClient;

    @Bean
    public RestTemplate getRestTemplate() {
        restTemplate = new RestTemplate();
        return restTemplate;

    }

    /**
     * Factory to build the WebClient - for Non Blocking IO
     * @return
     */
    @Bean
    public WebClient getWebClient() {
        webClient = WebClient.builder().build();
        return webClient;

    }

}
