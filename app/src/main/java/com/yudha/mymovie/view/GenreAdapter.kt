package com.yudha.mymovie.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.model.Genre
import com.yudha.mymovie.model.GenreResult

/**
 * Created by yudha on 16,July,2019
 */
class GenreAdapter: RecyclerView.Adapter<GenreAdapter.viewHolder>() {

    private var response = Genre()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_genre, p0, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int = response.genres.size
    override fun onBindViewHolder(p0: viewHolder, p1: Int) {
        val genre = response.genres.get(p1)
        p0.updateView(genre)
    }

    fun updateGenre(genre: Genre){
        this.response = genre
        notifyDataSetChanged()
    }

    class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var category = itemView.findViewById<TextView>(R.id.category)
        fun updateView(genre: GenreResult){
            category.text = genre.name
        }
    }
}