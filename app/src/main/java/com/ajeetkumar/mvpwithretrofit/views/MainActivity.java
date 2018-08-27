package com.ajeetkumar.mvpwithretrofit.views;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ajeetkumar.mvpwithretrofit.R;
import com.ajeetkumar.mvpwithretrofit.adapter.MoviesAdapter;
import com.ajeetkumar.mvpwithretrofit.contract.MainActivityContract;
import com.ajeetkumar.mvpwithretrofit.entity.Movie;
import com.ajeetkumar.mvpwithretrofit.presenters.MainViewPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

	MainActivityContract.Presenter mPresenter;
	ProgressDialog progressDialog;
	RecyclerView recyclerView;
	List<Movie> movieList;
	MoviesAdapter moviesAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPresenter = new MainViewPresenter(this);
	}

	//region ----- View Contract Methods -----

	@Override
	public void setupUI() {

		progressDialog = new ProgressDialog(this);
		recyclerView = findViewById(R.id.recycler_view);

		movieList = new ArrayList<>();
		moviesAdapter = new MoviesAdapter(movieList);

		recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
		recyclerView.setAdapter(moviesAdapter);

	}

	@Override
	public String getAPIKey() {
		return getString(R.string.api_key);
	}

	@Override
	public void displayMovieData(List<Movie> list) {

		Log.d("mvp", list.size() + "");

		movieList.clear();
		movieList.addAll(list);
		moviesAdapter.notifyDataSetChanged();

	}

	@Override
	public void showMessage(String msg) {

		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showProgressDialog() {

		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.setMessage("Loading...");
		} else {
			progressDialog.setIndeterminate(true);
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(false);

			try {
				progressDialog.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	@Override
	public void hideProgressDialog() {

		try {

			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
				progressDialog.hide();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//endregion
}
