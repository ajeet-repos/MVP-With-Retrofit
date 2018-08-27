package com.ajeetkumar.mvpwithretrofit.contract;

import com.ajeetkumar.mvpwithretrofit.entity.Movie;
import com.ajeetkumar.mvpwithretrofit.entity.TopMoviesResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by ajeet on 23-08-2018.
 */
public interface MainActivityContract {

	interface Model {

		void getTopMovies(String apiKey, final APIListener listener);	// Retrieve list of movies
	}

	interface View {

		void setupUI();
		String getAPIKey();	// This method give out api key from string resource mentioned as part or string.xml file in res/values folder.

		void displayMovieData(List<Movie> moviesList);
		void showMessage(String msg);	// To display message as Toast messages

		// Show and hide progress dialog
		void showProgressDialog();
		void hideProgressDialog();
	}

	interface Presenter {

		void getTopMovies(String apiKey);
	}

	interface APIListener {

		void onSuccess(Response<TopMoviesResponse> response);
		void onError(Response<TopMoviesResponse> response);
		void onFailure(Throwable t);
	}

}
