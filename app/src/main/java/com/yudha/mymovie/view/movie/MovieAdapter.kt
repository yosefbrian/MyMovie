package com.yudha.mymovie.view.movie

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.yudha.mymovie.R
import com.yudha.mymovie.data.model.Movie
import com.yudha.mymovie.data.model.MovieResult
import com.yudha.mymovie.utils.IMG_URL
import com.yudha.mymovie.utils.MOVIE_ID
import com.yudha.mymovie.view.details.MovieDetailsActivity

/**
 * Created by yudha on 18,July,2019
 */
class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val movieList = mutableListOf<MovieResult>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_movie, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val movie = movieList.get(p1)
        p0.updateView(movie)
    }

    fun updateData(movie: Movie){
        this.movieList.addAll(movie.results)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val category: TextView = itemView.findViewById(R.id.title)
        private val linItem: RelativeLayout = itemView.findViewById(R.id.linItem)
        private val image: ImageView = itemView.findViewById(R.id.poster)
        private val itemPosterPalette: LinearLayout = itemView.findViewById(R.id.item_poster_palette)
        fun updateView(movie: MovieResult){
            category.text = movie.title
            Glide.with(itemView.context)
                .load(IMG_URL+movie.posterPath)
                .listener(
                    GlidePalette.with(IMG_URL+movie.posterPath)
                    .use(BitmapPalette.Profile.VIBRANT_DARK)
                    .intoBackground(itemPosterPalette)
                    .crossfade(true))
                .into(image)

            linItem.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, MovieDetailsActivity::class.java).apply {
                    putExtra(MOVIE_ID, movie.id)})
            }
        }
    }
}
