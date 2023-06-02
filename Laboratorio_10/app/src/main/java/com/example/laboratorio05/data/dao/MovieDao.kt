package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.MovieWithActor

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieModel>

    @Transaction //Permite hacer rollback por si algo falla
    @Insert //Inserta en la base de datos
    suspend fun insertMovie(newMovie: MovieModel)

    @Query("SELECT * FROM movie_table WHERE movieId = :movieId") //Busca por id
    suspend fun getMovieWithActorsById(movieId: Int): MovieWithActor?
}