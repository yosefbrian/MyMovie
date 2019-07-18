package com.yudha.mymovie.view.movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.model.Movie
import com.yudha.mymovie.model.MovieResult
import com.yudha.mymovie.utils.ItemClickListener

/**
 * Created by yudha on 18,July,2019
 */
class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var response = Movie()
    private var clickListener: ItemClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_genre, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = response.results.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val movie = response.results.get(p1)
        p0.updateView(movie)
        p0.itemView.setOnClickListener {
            clickListener?.onClick(movie.id)
        }
    }

    fun updateData(movie: Movie, clickListener: ItemClickListener){
        this.response = movie
        this.clickListener = clickListener
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var category: TextView = itemView.findViewById(R.id.category)
        fun updateView(movie: MovieResult){
            category.text = movie.title
        }
    }
}
