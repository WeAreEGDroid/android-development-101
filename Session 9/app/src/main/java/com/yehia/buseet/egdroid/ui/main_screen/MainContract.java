package com.yehia.buseet.egdroid.ui.main_screen;

public interface MainContract {

    interface View {
        void showLoading();

        void hideLoading();

        void showData(String s);

        void showError(String error);
    }


    interface presenter {
        void getData();
        void attach();
        void detach();
    }
}
