package com.yehia.buseet.egdroid.di.component;

import com.yehia.buseet.egdroid.di.module.ApplicationModule;
import com.yehia.buseet.egdroid.ui.main_screen.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
