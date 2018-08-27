package com.ajeetkumar.mvpwithretrofit.entity;

import java.util.List;

/**
 * Created by ajeet on 24-08-2018.
 */
public class TopMoviesResponse {

	private List<Movie> results;

	private String page;

	private String total_pages;

	private String total_results;

	//region ----- Getters And Setters -----

	public List<Movie> getResults() {
		return results;
	}

	public String getPage() {
		return page;
	}

	public String getTotal_pages() {
		return total_pages;
	}

	public String getTotal_results() {
		return total_results;
	}

	//endregion


}
