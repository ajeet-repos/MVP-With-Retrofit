package com.ajeetkumar.mvpwithretrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajeetkumar.mvpwithretrofit.R;
import com.ajeetkumar.mvpwithretrofit.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ajeet on 24-08-2018.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

	private List<Movie> movieList;

	public MoviesAdapter(List<Movie> list) {

		movieList = list;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

		Movie movie = movieList.get(position);

		holder.movieName.setText(movie.getOriginal_title());
		Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path()).into(holder.moviePoster);
	}

	@Override
	public int getItemCount() {
		
		return movieList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		public ViewHolder(View view) {
			super(view);

			movieName = view.findViewById(R.id.movie_name);
			moviePoster = view.findViewById(R.id.movie_poster);
		}

		ImageView moviePoster;
		TextView movieName;
	}
}
