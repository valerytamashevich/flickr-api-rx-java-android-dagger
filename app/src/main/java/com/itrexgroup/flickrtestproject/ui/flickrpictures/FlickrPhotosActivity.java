package com.itrexgroup.flickrtestproject.ui.flickrpictures;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.itrexgroup.flickrtestproject.R;
import com.itrexgroup.flickrtestproject.data.model.Photo;
import com.itrexgroup.flickrtestproject.ui.base.MVPActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class FlickrPhotosActivity extends MVPActivity<FlickrPhotosPresenter, FlicrPhotosView>
        implements FlicrPhotosView,
        PhotosAdapter.Callback {

    @BindView(R.id.photos_loading_progress_bar)
    ProgressBar photosLoadingProgressBar;
    @BindView(R.id.photos_view_pager)
    ViewPager photossViewPager;

    @Inject
    FlickrPhotosPresenter presenter;

    private PhotosAdapter photosAdapter;

    @Override
    protected FlicrPhotosView getView() {
        return this;
    }

    @Override
    protected FlickrPhotosPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getContentView() {
        return R.layout.flickr_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photosAdapter = new PhotosAdapter(new ArrayList<>());
        photosAdapter.setCallback(this);

        photossViewPager.setAdapter(photosAdapter);
    }

    @Override
    public void updatePhotos(List<Photo> photos) {
        hideLoading();
        photosAdapter.updatePhotos(photos);
    }

    @Override
    public void showErrorMessage(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadPhotos() {
        showLoading();
        presenter.loadPhotos();
    }

    private void showLoading() {
        hideLoading();
        photosLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        photosLoadingProgressBar.setVisibility(View.GONE);
    }
}
