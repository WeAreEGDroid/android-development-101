package com.yehia.buseet.egdroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.util.DialogBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.userNameET)
    EditText userNameET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.signUpBtn)
    Button signUpBtn;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        signUpBtn.setOnClickListener(v -> signUp());
    }

    private void signUp() {
        if (isDataValid()) {
            progressBar.setVisibility(View.VISIBLE);
            String userName = userNameET.getText().toString().trim();
            String password = passwordET.getText().toString().trim();

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                finishAffinity();
                            } else {
                                DialogBuilder.buildDialog(SignUpActivity.this, "Error", task.getException().getMessage());
                            }
                        }
                    });

        }
    }


    private boolean isDataValid() {
        if (userNameET.getText().toString().trim().isEmpty()) {
            userNameET.setError("User name is required!");
            return false;
        }

        if (passwordET.getText().toString().trim().isEmpty()) {
            passwordET.setError("Password is required!");
            return false;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
