package com.yehia.buseet.egdroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity /*implements OnCommunicationListener*/ {

//    private MainFragment mainFragment;
//    private DetailsFragment detailsFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
//        detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_details);

    }

//    @Override
//    public void communicate(String word) {
//        detailsFragment.acceptCommunication(word);
//    }
}
