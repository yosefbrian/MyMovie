package com.yudha.mymovie.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import com.yudha.mymovie.model.Genre
import com.yudha.mymovie.model.Movie
import com.yudha.mymovie.view.GenreAdapter
import com.yudha.mymovie.view.movie.MovieAdapter

/**
 * Created by yudha on 17,July,2019
 */

@BindingAdapter("bind:response", "bind:clickListener")
fun bindListAdapter(reyclerView: RecyclerView, response: Genre?, clickListener: ItemClickListener?) {
    val adapter = GenreAdapter()
    reyclerView.adapter = adapter
    if (response != null && clickListener != null) adapter.updateData(response, clickListener)
}

@BindingAdapter("bind:response1", "bind:clickListener1")
fun bindMovieAdapter(reyclerView: RecyclerView, response1: Movie?, clickListener1: ItemClickListener?) {
    val adapter = MovieAdapter()
    reyclerView.adapter = adapter
    if (response1 != null && clickListener1 != null) adapter.updateData(response1, clickListener1)
}


@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

