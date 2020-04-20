package com.yehia.buseet.egdroid.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yehia.buseet.egdroid.activity.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    long insertMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Update
    void updateMovie(Movie movie);

    @Query("SELECT * FROM movies")
    List<Movie> getAllMovies();
}
