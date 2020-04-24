package com.yehia.buseet.egdroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.model.Post;
import com.yehia.buseet.egdroid.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.titleET)
    EditText titleET;
    @BindView(R.id.descriptionET)
    EditText descriptionET;
    @BindView(R.id.addPostBtn)
    Button addPostBtn;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.viewPostsBtn)
    Button viewPostsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addPostBtn.setOnClickListener(v -> addPost());
        viewPostsBtn.setOnClickListener(v -> startActivity(new Intent(this, PostsActivity.class)));
    }

    private void addPost() {
        progressBar.setVisibility(View.VISIBLE);
        String title = titleET.getText().toString().trim();
        String description = descriptionET.getText().toString().trim();

        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);

        String key = FirebaseDatabase.getInstance().getReference()
                .child(Constant.Firebase.POST_NODE).push().getKey();

        post.setKey(key);

        FirebaseDatabase.getInstance().getReference()
                .child(Constant.Firebase.POST_NODE)
                .child(key).setValue(post)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}