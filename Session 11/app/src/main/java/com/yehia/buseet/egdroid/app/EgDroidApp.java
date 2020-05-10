package com.yehia.buseet.egdroid.app;

import android.app.Application;

import com.appizona.yehiahd.fastsave.FastSave;
import com.yehia.buseet.egdroid.BuildConfig;
import com.yehia.buseet.egdroid.di.component.ApplicationComponent;
import com.yehia.buseet.egdroid.di.component.DaggerApplicationComponent;
import com.yehia.buseet.egdroid.di.module.ApplicationModule;

import timber.log.Timber;

public class EgDroidApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FastSave.init(this);

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .build();


        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
