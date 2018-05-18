package com.itrexgroup.flickrtestproject.ui.base;

import com.itrexgroup.flickrtestproject.data.RepositoryManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends View> {

    private V view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private RepositoryManager repositoryManager;

    @Inject
    public BasePresenter(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }

    public void setView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    protected void onCreate() {
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected void onDestroy() {
        compositeDisposable.clear();
    }

    protected void withDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public RepositoryManager getRepositoryManager() {
        return repositoryManager;
    }
}
