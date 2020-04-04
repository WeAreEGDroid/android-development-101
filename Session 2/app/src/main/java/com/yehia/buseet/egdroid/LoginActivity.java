package com.yehia.buseet.egdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText userNameET;
    private EditText passwordET;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameET = findViewById(R.id.user_name_ET);
        passwordET = findViewById(R.id.password_ET);

        loginBtn = findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Person person = new Person();
                person.setId(123);
                person.setName("Yehia");


                i.putExtra("person", person);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
