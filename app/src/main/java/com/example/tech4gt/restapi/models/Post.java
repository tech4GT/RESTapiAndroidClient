package com.example.tech4gt.restapi.models;

/**
 * Created by tech4GT on 12/21/17.
 */

public class Post {
    Integer userId,Id;
    String title,body;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        Id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
