package com.example.tech4gt.restapi.models;

/**
 * Created by tech4GT on 12/21/17.
 */

public class User {
    Integer id;
    String name,username,email;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public User(Integer id, String name, String username, String email) {

        id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
