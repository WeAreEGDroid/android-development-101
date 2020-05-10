package com.yehia.buseet.egdroid.data_model.remote;

import io.reactivex.Observable;

public interface IApiHelper {

    Observable<Boolean> getMovies();
}
