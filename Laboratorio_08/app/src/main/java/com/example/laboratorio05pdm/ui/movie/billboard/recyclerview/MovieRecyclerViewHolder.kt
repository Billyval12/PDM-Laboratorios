package com.example.laboratorio05pdm.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05pdm.data.model.MovieModel
import com.example.laboratorio05pdm.databinding.MovieItemBinding


class MovieRecyclerViewHolder (private val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.tittleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}