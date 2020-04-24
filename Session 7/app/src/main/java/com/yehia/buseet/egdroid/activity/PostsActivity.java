package com.yehia.buseet.egdroid.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.adapter.PostAdapter;
import com.yehia.buseet.egdroid.callback.OnPostActionListener;
import com.yehia.buseet.egdroid.model.Post;
import com.yehia.buseet.egdroid.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsActivity extends AppCompatActivity implements OnPostActionListener {

    @BindView(R.id.recyclerPosts)
    RecyclerView recyclerPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);


        recyclerPosts.setLayoutManager(new LinearLayoutManager(this));
        FirebaseDatabase.getInstance().getReference().child(Constant.Firebase.POST_NODE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Post> posts = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Post post = child.getValue(Post.class);
                    posts.add(post);
                }

                recyclerPosts.setAdapter(new PostAdapter(posts, PostsActivity.this, PostsActivity.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PostsActivity.this, databaseError.getDetails(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onPostLongClicked(Post post) {
        new AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Are you sure you want delete this item?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    deletePost(post);
                }).setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        }).show();
    }

    private void deletePost(Post post) {
        FirebaseDatabase.getInstance().getReference().child(Constant.Firebase.POST_NODE)
                .child(post.getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(PostsActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PostsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
