package com.example.tech4gt.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tech4gt.restapi.MainActivity;
import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.adapters.postsAdapter;
import com.example.tech4gt.restapi.models.Post;

import java.util.ArrayList;

public class PostsActivity extends AppCompatActivity {
public static final String TAG = "dbTag";
    RecyclerView rvList;
    ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);


        rvList = findViewById(R.id.rvlistItems);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvList.setAdapter(new postsAdapter(this));


    }
}
