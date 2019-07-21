package com.yudha.mymovie.view.genre

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.data.model.Genre
import com.yudha.mymovie.data.model.GenreResult
import com.yudha.mymovie.utils.GENRE_ID
import com.yudha.mymovie.view.movie.MovieActivity

/**
 * Created by yudha on 16,July,2019
 */
class GenreAdapter: RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var response = Genre()

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(view.context).inflate(R.layout.item_genre, view, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = response.genres.size
    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        val genre = response.genres.get(position)
        view.updateView(genre)
    }

    fun updateData(genre: Genre){
        this.response = genre
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var category: TextView = itemView.findViewById(R.id.title)
        var linItem: LinearLayout = itemView.findViewById(R.id.linItem)
        fun updateView(genre: GenreResult){
            category.text = genre.name
            linItem.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, MovieActivity::class.java).apply {
                    putExtra(GENRE_ID, genre.id)})
            }
        }
    }

}

