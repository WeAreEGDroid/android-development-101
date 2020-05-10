package com.yehia.buseet.egdroid.ui.main_screen;

import com.yehia.buseet.egdroid.data_model.DataManager;
import com.yehia.buseet.egdroid.ui.Base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainViewModel extends BaseViewModel {

    private DataManager dataManager;

    public MainViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Observable<Boolean> getMovies() {
        return dataManager.getMovies();
    }
}
