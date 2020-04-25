package com.yehia.buseet.egdroid.util;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class DialogBuilder {

    public static void buildDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .show();
    }
}
