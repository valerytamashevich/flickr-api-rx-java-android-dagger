package com.itrexgroup.flickrtestproject.data;

import com.itrexgroup.flickrtestproject.data.model.ResponseRecentPhotos;
import com.itrexgroup.flickrtestproject.utils.Constant;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMethods {

    @GET(Constant.REST_PATH)
    Single<ResponseRecentPhotos> getPictures(
            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("per_page") Integer perPage,
            @Query("page") Integer page,
            @Query("format") String format,
            @Query("nojsoncallback") Integer callbackType
    );
}
