
package com.yehia.buseet.egdroid.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Data {

    private Long limit;
    @SerializedName("movie_count")
    private Long movieCount;


    private List<Movie> movies;

    @SerializedName("page_number")
    private Long pageNumber;

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(Long movieCount) {
        this.movieCount = movieCount;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

}
