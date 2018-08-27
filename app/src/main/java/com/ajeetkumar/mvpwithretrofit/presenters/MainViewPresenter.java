package com.ajeetkumar.mvpwithretrofit.presenters;

import android.util.Log;

import com.ajeetkumar.mvpwithretrofit.contract.MainActivityContract;
import com.ajeetkumar.mvpwithretrofit.entity.TopMoviesResponse;
import com.ajeetkumar.mvpwithretrofit.models.MovieModel;

import retrofit2.Response;

/**
 * Created by ajeet on 22-08-2018.
 */
public class MainViewPresenter implements MainActivityContract.Presenter, MainActivityContract.APIListener {

	MainActivityContract.View mView;
	MainActivityContract.Model mModel;

	public MainViewPresenter(MainActivityContract.View view) {

		mView = view;
		mModel = new MovieModel();

		mView.setupUI();
		getTopMovies(mView.getAPIKey());
	}

	//region ----- Presenter Contract Methods -----

	@Override
	public void getTopMovies(String apiKey) {

		mModel.getTopMovies(apiKey, this);
	}

	//endregion


	//region ----- Network Listener -----

	@Override
	public void onSuccess(Response<TopMoviesResponse> response) {

		Log.d("mvp", response.body().getResults().size() + "");
		mView.displayMovieData(response.body().getResults());
	}

	@Override
	public void onError(Response<TopMoviesResponse> response) {

		mView.showMessage("Error Occured.");
	}

	@Override
	public void onFailure(Throwable t) {

		mView.showMessage(t.getMessage());
	}

	//endregion


}
