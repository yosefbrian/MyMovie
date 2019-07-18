package com.yudha.mymovie.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.yudha.mymovie.R
import com.yudha.mymovie.databinding.ActivityMainBinding
import com.yudha.mymovie.di.ViewModelFactory

import kotlinx.android.synthetic.main.activity_main.*
import java.io.LineNumberReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        observeGenreId()
    }

    private fun observeGenreId(){
        viewModel.genreIdLiveData.observe(this, Observer {

        })
    }
}
