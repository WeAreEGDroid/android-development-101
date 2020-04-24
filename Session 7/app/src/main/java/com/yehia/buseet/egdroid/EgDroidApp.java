package com.yehia.buseet.egdroid;

import android.app.Application;
import android.text.style.TtsSpan;

import com.appizona.yehiahd.fastsave.FastSave;

import java.net.ConnectException;

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
