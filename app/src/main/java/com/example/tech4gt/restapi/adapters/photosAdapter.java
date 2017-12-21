package com.example.tech4gt.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tech4gt.restapi.R;
import com.example.tech4gt.restapi.models.Photo;
import com.example.tech4gt.restapi.api.*;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tech4GT on 12/22/17.
 */

public class photosAdapter extends RecyclerView.Adapter<photosAdapter.photoViewHolder> {

    Context context;
    ArrayList<Photo> photos = new ArrayList<>();

    public photosAdapter(Context context) {
        this.context = context;

        apiService.getInstance().getPhotos().enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photos.addAll(response.body());
                photosAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @Override
    public photoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new photoViewHolder(((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(photoViewHolder holder, int position) {
        holder.tvTitle.setText(photos.get(position).getTitle());
        holder.tvUrl.setText(photos.get(position).getUrl());
        holder.tvThumbnailUrl.setText(photos.get(position).getThumbnailUrl());
        holder.tvAlbumId.setText(photos.get(position).getAlbumId().toString());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class photoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAlbumId, tvUrl, tvThumbnailUrl;

        public photoViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvPhotoTitle);
            tvAlbumId = itemView.findViewById(R.id.tvPhotoAlbumId);
            tvUrl = itemView.findViewById(R.id.tvPhotoUrl);
            tvThumbnailUrl = itemView.findViewById(R.id.tvPhotoThumbnailUrl);
        }
    }
}
