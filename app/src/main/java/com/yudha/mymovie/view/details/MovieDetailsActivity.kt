package com.yudha.mymovie.view.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.yudha.mymovie.R
import com.yudha.mymovie.di.ViewModelFactory
import com.yudha.mymovie.utils.GENRE_ID
import com.yudha.mymovie.utils.IMG_URL
import com.yudha.mymovie.utils.MOVIE_ID
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        viewModel = ViewModelProviders.of(this@MovieDetailsActivity, ViewModelFactory(this@MovieDetailsActivity)).get(MovieDetailsViewModel::class.java)
        viewModel.loadMovie(intent.getIntExtra(MOVIE_ID,0))

        viewModel.movieLiveData.observe(this, Observer {
            Glide.with(this).load(IMG_URL+viewModel.movieLiveData.value?.posterPath).into(image_view)
            textView.text = viewModel.movieLiveData.value?.title
            overview.text = viewModel.movieLiveData.value?.overview
            progress.visibility = View.GONE
        })


    }
}
