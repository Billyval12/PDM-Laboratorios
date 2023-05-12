package com.example.laboratorio05pdm.repositories

import com.example.laboratorio05pdm.data.model.MovieModel

class MovieRepository (private val movies: MutableList<MovieModel>){

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}