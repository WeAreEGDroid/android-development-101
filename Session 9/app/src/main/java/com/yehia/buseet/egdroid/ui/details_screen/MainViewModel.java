package com.yehia.buseet.egdroid.ui.details_screen;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> liveData = new MutableLiveData<>();
    private LiveData<String> _liveData = liveData;

    public LiveData<String> getLiveData() {
        return _liveData;
    }

    public void getData() {
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                liveData.postValue("yehia");
            }
        }, 5000);
    }

}
