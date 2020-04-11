package com.yehia.buseet.egdroid.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class EgDroidApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
