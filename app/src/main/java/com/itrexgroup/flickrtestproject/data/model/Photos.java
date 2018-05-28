package com.itrexgroup.flickrtestproject.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

    private Integer page;
    private Integer pages;
    private Integer perpage;
    private Integer total;
    @SerializedName("photo")
    private List<Photo> photos = null;

    public Integer getPage() {
        return page;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}