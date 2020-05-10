package com.yehia.buseet.egdroid.data_model;

import com.yehia.buseet.egdroid.data_model.local.FastLocalHlper;
import com.yehia.buseet.egdroid.data_model.local.LocalDataHelper;
import com.yehia.buseet.egdroid.data_model.remote.ApiHelper;
import com.yehia.buseet.egdroid.data_model.remote.IApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

public class DataManager {

    private IApiHelper apiHelper;
    private FastLocalHlper localDataHelper;


    public DataManager(IApiHelper apiHelper, FastLocalHlper localDataHelper) {
        this.apiHelper = apiHelper;
        this.localDataHelper = localDataHelper;
    }

    public Observable<Boolean> getMovies() {
        return apiHelper.getMovies();
    }
}
