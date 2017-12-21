package com.example.tech4gt.restapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tech4GT on 12/22/17.
 */

public class apiService {
    private static final API instance = getInstance();


    private apiService() {
    }

    public static API getInstance() {
        if (instance == null) {
            return new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(API.class);

        } else {
            return instance;
        }
    }


}
