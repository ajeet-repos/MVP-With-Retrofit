package com.ajeetkumar.mvpwithretrofit.entity;

/**
 * Created by ajeet on 24-08-2018.
 */
public class Movie {

	private String vote_average;

	private String backdrop_path;

	private String adult;

	private String id;

	private String title;

	private String overview;

	private String original_language;

	private String[] genre_ids;

	private String release_date;

	private String original_title;

	private String vote_count;

	private String poster_path;

	private String video;

	private String popularity;

	//region ----- Getters And Setters -----

	public String getVote_average() {
		return vote_average;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public String getAdult() {
		return adult;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getOverview() {
		return overview;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public String[] getGenre_ids() {
		return genre_ids;
	}

	public String getRelease_date() {
		return release_date;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public String getVote_count() {
		return vote_count;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public String getVideo() {
		return video;
	}

	public String getPopularity() {
		return popularity;
	}

	//endregion

}
