package com.yehia.buseet.egdroid.activity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.appizona.yehiahd.fastsave.FastSave;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.activity.model.Movie;
import com.yehia.buseet.egdroid.database.MoviesDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.delete_shared_prefs)
    Button deleteSharedPrefs;
    private MoviesDatabase database;

    @BindView(R.id.selectBtn)
    Button selectBtn;
    @BindView(R.id.updateBtn)
    Button updateBtn;
    @BindView(R.id.insertBtn)
    Button insertBtn;
    @BindView(R.id.deleteBtn)
    Button deleteBtn;
    @BindView(R.id.insert_shared_prefs)
    Button insertSharedPrefs;
    @BindView(R.id.get_shared_prefs)
    Button getSharedPrefs;

    private int id = 500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        database = Room.databaseBuilder(this, MoviesDatabase.class, "moviesDB")
                .build();

        selectBtn.setOnClickListener(view -> {
            List<Movie> list = database.movieDao().getAllMovies();
            Toast.makeText(MainActivity.this, "SELECTED and size -> " + list.size(), Toast.LENGTH_SHORT).show();
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = new Movie();
                movie.setId(--id);
                movie.setTitle("Titleeee");
                movie.setDescription("setDescription");
                movie.setImageUrl("image");
                Toast.makeText(MainActivity.this, "Updated!", Toast.LENGTH_SHORT).show();
            }
        });
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Movie movie = new Movie();
                movie.setId(id++);
                movie.setTitle("Title");
                movie.setDescription("setDescription");
                movie.setImageUrl("image");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final long id = database.movieDao().insertMovie(movie);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Inserted id->" + id, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();


            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Movie movie = new Movie();
                movie.setId(--id);
                movie.setTitle("Title");
                movie.setDescription("setDescription");
                movie.setImageUrl("image");

                AsyncTask.execute(() -> {
                    database.movieDao().deleteMovie(movie);

                    runOnUiThread(() -> Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show());
                });


            }
        });

        insertSharedPrefs.setOnClickListener(v -> {

            Movie movie = new Movie();
            movie.setId(300);
            movie.setTitle("Title");
            movie.setDescription("setDescription");
            movie.setImageUrl("image");

//            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("id", movie.getId());
//            editor.putString("title", movie.getTitle());
//            editor.putString("description", movie.getDescription());
//            editor.putString("image", movie.getImageUrl());
//            editor.apply();

            Timber.e("An error happened here!");

        });

        getSharedPrefs.setOnClickListener(v -> {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            preferences.getString("title", "Not Found!");
        });

        deleteBtn.setOnClickListener(v -> {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("title");
            editor.apply();
        });

    }
}
