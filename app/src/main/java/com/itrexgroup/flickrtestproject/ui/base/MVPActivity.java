package com.itrexgroup.flickrtestproject.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class MVPActivity<PRESENTER extends BasePresenter, VIEW extends View> extends BaseActivity {

    PRESENTER presenter;

    protected abstract VIEW getView();
    protected abstract PRESENTER getPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = getPresenter();
        if (presenter != null) {
            presenter.setView(getView());
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (presenter != null) {
            presenter.onDestroy();
        }
    }
}
