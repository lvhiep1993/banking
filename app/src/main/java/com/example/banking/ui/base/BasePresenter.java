package com.example.banking.ui.base;

import android.support.annotation.Nullable;

public class BasePresenter<View> {

    @Nullable
    public View view = null;

    public void start(View view) {
        this.view = view;
    }

    public void stop() {
        this.view = null;
    }
}
