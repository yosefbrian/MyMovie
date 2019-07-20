package com.yudha.mymovie.view.movie

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.yudha.mymovie.R
import com.yudha.mymovie.databinding.ActivityMovieBinding
import com.yudha.mymovie.di.ViewModelFactory
import com.yudha.mymovie.utils.GENRE_ID
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieActivityViewModel
    var genreId = 0
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()

    }

    private fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        binding.lifecycleOwner = this
        binding.movieList.layoutManager = GridLayoutManager(this, 2)
        viewModel = ViewModelProviders.of(this@MovieActivity, ViewModelFactory(this@MovieActivity)).get(MovieActivityViewModel::class.java)
        binding.viewModel = viewModel
        genreId = intent.getIntExtra(GENRE_ID,0)
        viewModel.loadMovies(genreId, page)

        binding.movieList.addOnScrollListener( object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if(dy > 0) {
                    val visibleThreshold = 2
                    val layoutManager: GridLayoutManager = binding.movieList.layoutManager as GridLayoutManager
                    val lastItem = layoutManager.findLastCompletelyVisibleItemPosition()
                    val currentTotalCount = layoutManager.itemCount
                    if (currentTotalCount <= lastItem + visibleThreshold) {
                        page += 1
                        Toast.makeText(this@MovieActivity, page.toString(), Toast.LENGTH_LONG).show()
                        viewModel.loadMovies(genreId, page)
                    }
                }
            }
        })
    }
}
