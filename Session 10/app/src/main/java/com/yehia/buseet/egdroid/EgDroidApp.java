package com.yehia.buseet.egdroid;

import android.app.Application;

import com.appizona.yehiahd.fastsave.FastSave;

import timber.log.Timber;

public class EgDroidApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FastSave.init(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
