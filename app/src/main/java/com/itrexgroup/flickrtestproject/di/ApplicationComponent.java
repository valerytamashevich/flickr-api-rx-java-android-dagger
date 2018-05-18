package com.itrexgroup.flickrtestproject.di;

import com.itrexgroup.flickrtestproject.FlickrTestProjectApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {ApplicationModule.class, ApiModule.class, AndroidSupportInjectionModule.class})
@Singleton
public interface ApplicationComponent extends AndroidInjector<FlickrTestProjectApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<FlickrTestProjectApplication> {
    }
}
