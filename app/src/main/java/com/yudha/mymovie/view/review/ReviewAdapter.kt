package com.yudha.mymovie.view.review

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.data.model.Review
import com.yudha.mymovie.data.model.ReviewResult

/**
 * Created by yudha on 19,July,2019
 */
class ReviewAdapter: RecyclerView.Adapter<ReviewAdapter.ViewHolder>()  {

    private var response = Review()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_review, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = response.results.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val review = response.results.get(p1)
        p0.updateView(review)
    }

    fun updateData(review: Review){
        this.response = review
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val author: TextView = itemView.findViewById(R.id.txtAuthor)
        private val content: TextView = itemView.findViewById(R.id.txtContent)
        fun updateView(review: ReviewResult){
            author.text = review.author
            content.text = review.content
        }
    }
}