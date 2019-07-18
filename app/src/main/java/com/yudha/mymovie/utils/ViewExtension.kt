package com.yudha.mymovie.utils

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by yudha on 18,July,2019
 */

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}