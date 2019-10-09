package com.jcircle.reactive.spring.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jcircle.reactive.spring.model.Post;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse {



    private List<Post> postList = null;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }


}
