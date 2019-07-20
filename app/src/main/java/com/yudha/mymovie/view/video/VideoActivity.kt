package com.yudha.mymovie.view.video

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yudha.mymovie.di.ViewModelFactory
import com.yudha.mymovie.utils.MOVIE_ID
import android.net.Uri
import com.yudha.mymovie.R
import com.yudha.mymovie.utils.VID_URL


class VideoActivity : AppCompatActivity() {

    private lateinit var binding: com.yudha.mymovie.databinding.ActivityVideoBinding
    private lateinit var viewModel: VideoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }
    private fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video)
        binding.lifecycleOwner = this
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this@VideoActivity, ViewModelFactory(this@VideoActivity)).get(VideoViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.loadVideos(intent.getIntExtra(MOVIE_ID,0))
    }
}
