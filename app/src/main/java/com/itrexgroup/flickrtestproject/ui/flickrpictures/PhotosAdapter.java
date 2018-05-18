package com.itrexgroup.flickrtestproject.ui.flickrpictures;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itrexgroup.flickrtestproject.R;
import com.itrexgroup.flickrtestproject.data.model.Photo;

import java.util.List;

class PhotosAdapter extends PagerAdapter {

    private static final String TAG = PhotosAdapter.class.getName();

    private final List<Photo> photoList;
    private Callback callback;

    PhotosAdapter(List<Photo> photos) {
        this.photoList = photos;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        if (position == photoList.size() - 1) {
            if (callback != null) {
                callback.loadPhotos();
            }
        }

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.flicr_photo_layout, null);
        ImageView photoView = (ImageView) view.findViewById(R.id.photo_image_view);

        Photo photo = photoList.get(position);

        photoView.setContentDescription(photo.getTitle());

        String address = String.format(
                "https://farm%s.staticflickr.com/%s/%s_%s.jpg",
                photo.getFarm(),
                photo.getServer(),
                photo.getId(),
                photo.getSecret()
        );

        Glide.with(container.getContext())
                .load(address)
                .into(photoView);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void updatePhotos(List<Photo> photos) {
        this.photoList.addAll(photos);
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return photoList.get(position).getTitle();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void loadPhotos();
    }
}
