package com.itrexgroup.flickrtestproject.ui.flickrpictures;

import android.os.Bundle;

import com.itrexgroup.flickrtestproject.R;
import com.itrexgroup.flickrtestproject.ui.base.MVPActivity;

import javax.inject.Inject;

public class FlickrPicturesActivity extends MVPActivity<FlickrPicturesPresenter, FlicrPicturesView> implements FlicrPicturesView {

    @Inject
    FlickrPicturesPresenter presenter;

    @Override
    protected FlicrPicturesView getView() {
        return this;
    }

    @Override
    protected FlickrPicturesPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
