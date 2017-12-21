package com.example.tech4gt.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tech4gt.restapi.api.*;

import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by tech4GT on 12/22/17.
 */

public class usersAdapter extends RecyclerView.Adapter<usersAdapter.userViewHolder> {

    Context context;
    ArrayList<User> users = new ArrayList<>();

    public usersAdapter(Context context) {
        this.context = context;
        apiService.getInstance().getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                users.addAll(response.body());
                usersAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @Override
    public userViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new userViewHolder(((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.list_item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(userViewHolder holder, int position) {
        holder.tvName.setText(users.get(position).getName());
        holder.tvEmail.setText(users.get(position).getEmail());
        holder.tvUsername.setText(users.get(position).getUsername());
        holder.tvId.setText(users.get(position).getId().toString());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class userViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvUsername, tvId, tvEmail;

        public userViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvUserName);
            tvId = itemView.findViewById(R.id.tvUserId);
            tvUsername = itemView.findViewById(R.id.tvUserUsername);
            tvEmail = itemView.findViewById(R.id.tvUserEmail);

        }
    }
}
