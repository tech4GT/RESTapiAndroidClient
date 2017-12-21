package com.example.tech4gt.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.api.*;
import com.example.tech4gt.restapi.models.Todo;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tech4GT on 12/22/17.
 */

public class todosAdapter extends RecyclerView.Adapter<todosAdapter.todoViewHolder> {
    Context context;
    ArrayList<Todo> todos = new ArrayList<>();

    public todosAdapter(Context context) {
        this.context = context;

        apiService.getInstance().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                todos.addAll(response.body());
                todosAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    @Override
    public todoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new todoViewHolder(((LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.list_item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(todoViewHolder holder, int position) {
        holder.tvTitle.setText(todos.get(position).getTitle());
        holder.tvUserId.setText(todos.get(position).getUserId().toString());
        holder.cbCompleted.setChecked(todos.get(position).isCompleted());

    }

    @Override
    public int getItemCount() {
        return this.todos.size();
    }

    class todoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvUserId;
        CheckBox cbCompleted;

        public todoViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTodoTitle);
            tvUserId = itemView.findViewById(R.id.tvTodoUserId);
            cbCompleted = itemView.findViewById(R.id.cbTodoCompleted);
        }
    }
}
