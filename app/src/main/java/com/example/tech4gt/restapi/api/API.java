package com.example.tech4gt.restapi.api;

import com.example.tech4gt.restapi.models.Photo;
import com.example.tech4gt.restapi.models.Post;
import com.example.tech4gt.restapi.models.Todo;
import com.example.tech4gt.restapi.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tech4GT on 12/22/17.
 */

public interface API {

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/users")
    Call<ArrayList<User>> getUsers();

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotos();

    @GET("/todos")
    Call<ArrayList<Todo>> getTodos();


}
