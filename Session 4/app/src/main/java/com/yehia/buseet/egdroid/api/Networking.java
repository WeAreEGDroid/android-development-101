package com.yehia.buseet.egdroid.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.yehia.buseet.egdroid.callback.OnMoviesListener;
import com.yehia.buseet.egdroid.model.Response;

public class Networking {

    public static void getMovies(final OnMoviesListener listener) {
        AndroidNetworking
                .get("https://yts.mx/api/v2/list_movies.json")
                .addQueryParameter("limit", "50")
                .addQueryParameter("page", "2")
                .build()
                .getAsObject(Response.class, new ParsedRequestListener<Response>() {
                    @Override
                    public void onResponse(Response response) {
                        listener.onSuccess(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onFailed(anError.getErrorDetail());
                    }
                });
    }
}
