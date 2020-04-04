package com.yehia.buseet.egdroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //    private Button navBtn;
    private Button login;
    private Button signUp;
//    private Button callBtn;
//    private EditText userNameET;
//    private EditText passwordET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        navBtn = findViewById(R.id.nav_btn);
//        callBtn = findViewById(R.id.call_btn);
//        userNameET = findViewById(R.id.user_name_ET);
//        passwordET = findViewById(R.id.password_ET);
//
//        navBtn.setOnClickListener(this);
//        callBtn.setOnClickListener(this);

        login = findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, 100);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            Person person = data.getExtras().getParcelable("person");
            Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.nav_btn:
//                //getToDetailsActivity();
//                break;
//
//            case R.id.call_btn:
//                //makeCall();
//                break;
        }
    }

//    private void makeCall() {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:01095256297"));
//        startActivity(intent);
//    }
//
//    private void getToDetailsActivity() {
//        String userName = userNameET.getText().toString();
//        String password = passwordET.getText().toString();
//
//        if (userName.equals("Yehia") && password.equals("123")) {
//            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//            intent.putExtra("name", userName);
//            startActivity(intent);
//        } else {
//            Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
//        }
//    }
}
