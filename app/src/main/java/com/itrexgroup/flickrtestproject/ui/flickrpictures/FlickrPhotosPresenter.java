package com.itrexgroup.flickrtestproject.ui.flickrpictures;

import com.itrexgroup.flickrtestproject.R;
import com.itrexgroup.flickrtestproject.data.RepositoryManager;
import com.itrexgroup.flickrtestproject.data.model.ResponseRecentPhotos;
import com.itrexgroup.flickrtestproject.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FlickrPhotosPresenter extends BasePresenter<FlicrPhotosView> {

    private static final int INIT_PAGE_NUMBER = 1;
    private static final String OK_STATUS = "ok";

    private int pageNumber = INIT_PAGE_NUMBER;

    @Inject
    public FlickrPhotosPresenter(RepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    protected void onCreate() {
        loadPhotos();
    }

    public void loadPhotos() {
        withDisposable(
                getRepositoryManager().getServiceNetwork().getPhotos(pageNumber)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                response -> {
                                    if (response.getStat().equalsIgnoreCase(OK_STATUS)) {
                                        savePageAndUpdatePhotos(response);
                                    } else {
                                        getView().showErrorMessage(R.string.photo_fetching_error);
                                    }
                                },
                                throwable -> getView().showErrorMessage(R.string.photo_fetching_error)
                        )
        );
    }

    private void savePageAndUpdatePhotos(ResponseRecentPhotos response) {
        pageNumber = response.getPhotos().getPage() + 1;
        getView().updatePhotos(response.getPhotos().getPhoto());
    }
}
