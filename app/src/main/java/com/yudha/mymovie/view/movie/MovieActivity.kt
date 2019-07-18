package com.yudha.mymovie.view.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.yudha.mymovie.R
import com.yudha.mymovie.databinding.ActivityMovieBinding
import com.yudha.mymovie.di.ViewModelFactory
import com.yudha.mymovie.utils.GENRE_ID

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    private fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this@MovieActivity, ViewModelFactory(this@MovieActivity)).get(MovieActivityViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.loadMovies(intent.getIntExtra(GENRE_ID,0))
        observeGenreId()
    }

    private fun observeGenreId(){
        viewModel.movieIdLiveData.observe(this, Observer {
            startActivity(
                Intent(this, MovieActivity::class.java).apply {
                    putExtra(GENRE_ID, viewModel.movieIdLiveData.value)
                })
        })
    }
}
