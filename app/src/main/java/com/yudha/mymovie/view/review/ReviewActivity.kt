package com.yudha.mymovie.view.review

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yudha.mymovie.R
import com.yudha.mymovie.databinding.ActivityReviewBinding
import com.yudha.mymovie.di.ViewModelFactory
import com.yudha.mymovie.utils.MOVIE_ID
import kotlinx.android.synthetic.main.activity_review.view.*

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    private lateinit var viewModel: ReviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    private fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_review)
        binding.lifecycleOwner = this
        binding.reviewList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this@ReviewActivity, ViewModelFactory(this@ReviewActivity)).get(ReviewViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.loadReviews(intent.getIntExtra(MOVIE_ID,0))
    }
}
