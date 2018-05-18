package com.itrexgroup.flickrtestproject.ui.flickrpictures;

import com.itrexgroup.flickrtestproject.data.model.Photo;
import com.itrexgroup.flickrtestproject.ui.base.View;

import java.util.List;

public interface FlicrPhotosView extends View {

    void updatePhotos(List<Photo> photos);

    void showErrorMessage(String message);
}
