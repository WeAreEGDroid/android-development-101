package com.yehia.buseet.egdroid.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yehia.buseet.egdroid.activity.model.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}
