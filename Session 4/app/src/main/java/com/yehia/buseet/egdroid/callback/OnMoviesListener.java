package com.yehia.buseet.egdroid.callback;

import com.yehia.buseet.egdroid.model.Response;

public interface OnMoviesListener {

    void onSuccess(Response response);

    void onFailed(String message);
}
