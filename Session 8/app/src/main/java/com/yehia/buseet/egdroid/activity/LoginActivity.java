package com.yehia.buseet.egdroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.yehia.buseet.egdroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.userNameET)
    EditText userNameET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    @BindView(R.id.signUpBtn)
    Button signUpBtn;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.forgotPasswordTV)
    TextView forgotPasswordTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        FirebaseMessaging.getInstance().subscribeToTopic("mobile");

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        signUpBtn.setOnClickListener(v -> startActivity(new Intent(this, SignUpActivity.class)));

        loginBtn.setOnClickListener(v -> login());

        forgotPasswordTV.setOnClickListener(v -> forgotPassword());
    }

    private void forgotPassword() {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }

    private void login() {
        if (isDataValid()) {
            progressBar.setVisibility(View.VISIBLE);
            String userName = userNameET.getText().toString().trim();
            String password = passwordET.getText().toString().trim();

            FirebaseAuth.getInstance().signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
}
