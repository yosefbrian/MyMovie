package com.yudha.mymovie.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.model.Genre
import com.yudha.mymovie.model.GenreResult
import com.yudha.mymovie.utils.ItemClickListener

/**
 * Created by yudha on 16,July,2019
 */
class GenreAdapter: RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var response = Genre()
    private var clickListener: ItemClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_genre, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = response.genres.size
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val genre = response.genres.get(p1)
        p0.updateView(genre)
        p0.itemView.setOnClickListener {
            clickListener?.onClick(genre.id)
        }
    }

    fun updateData(genre: Genre, clickListener: ItemClickListener){
        this.response = genre
        this.clickListener = clickListener
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var category: TextView = itemView.findViewById(R.id.category)
        fun updateView(genre: GenreResult){
            category.text = genre.name
        }
    }
}
