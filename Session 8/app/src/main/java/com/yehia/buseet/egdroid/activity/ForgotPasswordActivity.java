package com.yehia.buseet.egdroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.util.DialogBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgotPasswordActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.emailET)
    EditText emailET;
    @BindView(R.id.resetPasswordBtn)
    Button resetPasswordBtn;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);

        resetPasswordBtn.setOnClickListener(v -> reset());
    }

    private void reset() {
        progressBar.setVisibility(View.VISIBLE);
        String email = emailET.getText().toString().trim();

        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    finish();
                } else {
                    DialogBuilder.buildDialog(ForgotPasswordActivity.this, "Error", task.getException().getMessage());
                }
            }
        });

    }
}
