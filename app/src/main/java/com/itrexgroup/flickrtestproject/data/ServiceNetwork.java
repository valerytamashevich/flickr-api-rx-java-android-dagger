package com.itrexgroup.flickrtestproject.data;

import com.itrexgroup.flickrtestproject.data.model.ResponseRecentPhotos;

import io.reactivex.Single;

public interface ServiceNetwork {

    Single<ResponseRecentPhotos> getPhotos(int pageNumber);
}
