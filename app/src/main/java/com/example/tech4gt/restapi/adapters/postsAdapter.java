package com.example.tech4gt.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tech4gt.restapi.api.apiService;

import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

/**
 * Created by tech4GT on 12/22/17.
 */

public class postsAdapter extends RecyclerView.Adapter<postsAdapter.postViewHolder> {
    public static final String TAG = "mytag";
    Context context;
    ArrayList<Post> posts = new ArrayList<>();

    public postsAdapter(Context context) {
        Log.d(TAG, "postsAdapter: ");
        this.context = context;
        Call<ArrayList<Post>> getPostsCall = apiService.getInstance().getPosts();
        getPostsCall.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                posts.addAll(response.body());
                Log.d(TAG, String.valueOf(response.body().size()));
                postsAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public postViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");

        return new postViewHolder(((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.list_item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(postViewHolder holder, int position) {
        holder.tvTitle.setText(posts.get(position).getTitle());
        holder.tvUserId.setText(posts.get(position).getUserId().toString());
        holder.tvBody.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }

    class postViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId, tvTitle, tvBody;


        public postViewHolder(View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tvPostUserId);
            tvBody = itemView.findViewById(R.id.tvPostBody);
            tvTitle = itemView.findViewById(R.id.tvPostTitle);
        }
    }
}
