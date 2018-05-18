package com.itrexgroup.flickrtestproject.di;

import android.content.Context;

import com.itrexgroup.flickrtestproject.FlickrTestProjectApplication;
import com.itrexgroup.flickrtestproject.data.RepositoryManager;
import com.itrexgroup.flickrtestproject.data.RepositoryManagerImpl;
import com.itrexgroup.flickrtestproject.ui.flickrpictures.FlickrPhotosActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ApplicationModule {

    @Singleton
    @Provides
    public static Context provideContext() {
        return FlickrTestProjectApplication.getContext();
    }

    @Singleton
    @Provides
    public static RepositoryManager provideRepositoryManager(RepositoryManagerImpl repositoryManager) {
        return repositoryManager;
    }

    @ContributesAndroidInjector
    abstract FlickrPhotosActivity componentFlickrPicturesInjector();
}
