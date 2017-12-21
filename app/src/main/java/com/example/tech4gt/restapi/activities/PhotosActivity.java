package com.example.tech4gt.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.adapters.photosAdapter;

public class PhotosActivity extends AppCompatActivity {
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        rvList = findViewById(R.id.rvlistItems);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(new photosAdapter(this));

    }
}
