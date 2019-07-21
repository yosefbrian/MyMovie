package com.yudha.mymovie.view.genre

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.yudha.mymovie.R
import com.yudha.mymovie.databinding.ActivityGenreBinding
import com.yudha.mymovie.di.ViewModelFactory

class GenreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenreBinding
    private lateinit var viewModel: GenreViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    private fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_genre)
        binding.lifecycleOwner = this
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(GenreViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}
