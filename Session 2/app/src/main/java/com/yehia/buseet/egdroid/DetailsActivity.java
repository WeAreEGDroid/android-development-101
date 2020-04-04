package com.yehia.buseet.egdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView userNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        userNameTV = findViewById(R.id.user_name_TV);

        String userName = getIntent().getExtras().getString("name");
        userNameTV.setText(userName);


    }
}
