package com.example.laboratorio05pdm

import android.app.Application
import com.example.laboratorio05pdm.data.movies
import com.example.laboratorio05pdm.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}