package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.laboratorio05.data.model.CastModel

@Dao
interface CastDao {
    //Estrategia para metodos de tipo transaccion por si hay conflictos
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCast(casting: CastModel)
}