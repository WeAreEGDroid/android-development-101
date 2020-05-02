package com.yehia.buseet.egdroid.ui.main_screen;

import android.os.Handler;

public class MainPresenter implements MainContract.presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        this.mView = view;
    }


    public void detach() {
        mView = null;
    }

    @Override
    public void getData() {
        mView.showLoading();
        final Handler handler = new Handler();



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mView != null) {
                    getCacheFirst();
                    mView.hideLoading();
                    mView.showData("Yehia");
                }


//                mView.showError("");
            }
        }, 5000);
    }

    private void getCacheFirst() {

    }

    @Override
    public void attach() {

    }
}
