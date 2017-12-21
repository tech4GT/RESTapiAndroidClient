package com.example.tech4gt.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.adapters.todosAdapter;

public class TodosActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        rv = findViewById(R.id.rvlistItems);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new todosAdapter(this));

    }
}
