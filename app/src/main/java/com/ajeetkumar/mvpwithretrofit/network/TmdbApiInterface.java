package com.ajeetkumar.mvpwithretrofit.network;

import com.ajeetkumar.mvpwithretrofit.entity.TopMoviesResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by ajeet on 24-08-2018.
 */
public interface TmdbApiInterface {

	@GET("/3/discover/movie")
	Call<TopMoviesResponse> getTopMovies(@QueryMap Map<String, String> options);
}