package com.yudha.mymovie.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.support.v7.widget.DividerItemDecoration



/**
 * Created by yudha on 17,July,2019
 */

@BindingAdapter("bind:setAdapter")
fun bindListAdapter(recyclerView: RecyclerView, adapter : RecyclerView.Adapter<*>) {
    recyclerView.adapter = adapter
}


@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

