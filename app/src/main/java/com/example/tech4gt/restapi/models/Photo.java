package com.example.tech4gt.restapi.models;

/**
 * Created by tech4GT on 12/21/17.
 */

public class Photo {
    Integer albumId,id;
    String title,url,thumbnailUrl;

    public Integer getAlbumId() {
        return albumId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public Photo(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {

        this.albumId = albumId;
        id = id;
        title = title;
        url = url;
        thumbnailUrl = thumbnailUrl;
    }
}
