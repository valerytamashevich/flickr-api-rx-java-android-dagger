package com.itrexgroup.flickrtestproject.data;

import com.itrexgroup.flickrtestproject.data.model.ResponseRecentPhotos;
import com.itrexgroup.flickrtestproject.utils.Constant;

import javax.inject.Inject;

import io.reactivex.Single;

public class ServiceNetworkImp implements ServiceNetwork {

    private ApiMethods apiMethods;

    @Inject
    public ServiceNetworkImp(ApiMethods apiMethods) {
        this.apiMethods = apiMethods;
    }

    @Override
    public Single<ResponseRecentPhotos> getPhotos(int pageNumber) {
        return apiMethods.getPictures(
                Constant.GET_RECENT_PICTURES,
                Constant.API_KEY,
                Constant.ELEMENTS_PER_PAGE_NUMBER,
                pageNumber,
                Constant.FORMAT,
                Constant.FLICKR_CALLBACK_TYPE);
    }
}
