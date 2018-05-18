package com.itrexgroup.flickrtestproject.ui.flickrpictures;

import com.itrexgroup.flickrtestproject.data.RepositoryManager;
import com.itrexgroup.flickrtestproject.ui.base.BasePresenter;

import javax.inject.Inject;

public class FlickrPicturesPresenter extends BasePresenter<FlicrPicturesView> {

    @Inject
    public FlickrPicturesPresenter(RepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
