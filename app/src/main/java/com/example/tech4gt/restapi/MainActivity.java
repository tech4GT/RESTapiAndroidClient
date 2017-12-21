package com.example.tech4gt.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.tech4gt.restapi.activities.PhotosActivity;
import com.example.tech4gt.restapi.activities.PostsActivity;
import com.example.tech4gt.restapi.activities.TodosActivity;
import com.example.tech4gt.restapi.activities.UsersActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnPhotos, btnPosts, btnUsers, btnTodos;
    public static final String TAG = "logtag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPhotos = findViewById(R.id.btnPhotos);
        btnPhotos.setOnClickListener(this);
        btnPosts = findViewById(R.id.btnPosts);
        btnPosts.setOnClickListener(this);
        btnTodos = findViewById(R.id.btnTodos);
        btnTodos.setOnClickListener(this);
        btnUsers = findViewById(R.id.btnUsers);
        btnUsers.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPosts:
                startActivity(new Intent(MainActivity.this, PostsActivity.class));
                break;
            case R.id.btnPhotos:
                startActivity(new Intent(MainActivity.this, PhotosActivity.class));
                break;
            case R.id.btnUsers:
                startActivity(new Intent(MainActivity.this, UsersActivity.class));
                break;
            case R.id.btnTodos:
                startActivity(new Intent(MainActivity.this, TodosActivity.class));

        }
    }
}
