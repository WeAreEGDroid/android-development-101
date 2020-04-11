package com.yehia.buseet.egdroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yehia.buseet.egdroid.adapter.MoviesAdapter;
import com.yehia.buseet.egdroid.api.Networking;
import com.yehia.buseet.egdroid.callback.OnMoviesListener;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.model.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMovies);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar.setVisibility(View.VISIBLE);

        Networking.getMovies(new OnMoviesListener() {
            @Override
            public void onSuccess(Response response) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(new MoviesAdapter(response.getData().getMovies(), MainActivity.this));
            }

            @Override
            public void onFailed(String message) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
