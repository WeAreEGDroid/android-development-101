package com.yehia.buseet.egdroid.ui.details_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import com.yehia.buseet.egdroid.R;

public class DetailsActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getData();


        viewModel.getLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(DetailsActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
