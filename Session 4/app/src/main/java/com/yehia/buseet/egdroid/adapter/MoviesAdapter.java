package com.yehia.buseet.egdroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yehia.buseet.egdroid.utils.CircleTransform;
import com.yehia.buseet.egdroid.R;
import com.yehia.buseet.egdroid.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private List<Movie> movieList;
    private Context mContext;

    public MoviesAdapter(List<Movie> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MoviesAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MovieHolder holder, int position) {

        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTV;
        private TextView descriptionTV;
        private View root;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movieImg);
            titleTV = itemView.findViewById(R.id.titleTV);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            root = itemView.findViewById(R.id.root);
        }

        public void bind(Movie movie) {

            Picasso.get().load(movie.getLargeCoverImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .transform(new CircleTransform())
                    .into(imageView);

            titleTV.setText(movie.getTitle());
            descriptionTV.setText(movie.getSummary());
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}
