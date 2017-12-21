package com.example.tech4gt.restapi.models;

/**
 * Created by tech4GT on 12/21/17.
 */

public class Todo {
    Integer userId,id;
    String title;
    boolean completed;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Todo(Integer userId, Integer id, String title, boolean completed) {

        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}
