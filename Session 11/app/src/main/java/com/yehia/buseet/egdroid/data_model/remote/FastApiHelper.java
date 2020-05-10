package com.yehia.buseet.egdroid.data_model.remote;

import io.reactivex.Observable;

public class FastApiHelper implements IApiHelper {
    @Override
    public Observable<Boolean> getMovies() {
        return Observable.just(false);
    }
}
