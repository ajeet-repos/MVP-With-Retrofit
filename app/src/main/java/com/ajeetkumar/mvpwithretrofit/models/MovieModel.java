package com.ajeetkumar.mvpwithretrofit.models;

import com.ajeetkumar.mvpwithretrofit.contract.MainActivityContract;
import com.ajeetkumar.mvpwithretrofit.entity.TopMoviesResponse;
import com.ajeetkumar.mvpwithretrofit.network.TmdbApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ajeet on 23-08-2018.
 */
public class MovieModel implements MainActivityContract.Model {


	@Override
	public void getTopMovies(String apiKey, final MainActivityContract.APIListener listener) {

		try {

			// 1. Create a Retrofit client and using the interface make the call
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("https://api.themoviedb.org")
					.addConverterFactory(GsonConverterFactory.create())
					.build();

			TmdbApiInterface service = retrofit.create(TmdbApiInterface.class);

			HashMap<String, String> options = new HashMap<>();
			options.put("api_key", apiKey);
			options.put("language", "en-US");
			options.put("sort_by", "popularity.desc");
			options.put("include_adult", "false");
			options.put("include_video", "false");
			options.put("page", "1");

			Call<TopMoviesResponse> call = service.getTopMovies(options);
			call.enqueue(new Callback<TopMoviesResponse>() {
				@Override
				public void onResponse(Call<TopMoviesResponse> call, Response<TopMoviesResponse> response) {

					if (response.isSuccessful()) {

						listener.onSuccess(response);
					} else {

						listener.onError(response);
					}
				}

				@Override
				public void onFailure(Call<TopMoviesResponse> call, Throwable t) {

					listener.onFailure(t);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
