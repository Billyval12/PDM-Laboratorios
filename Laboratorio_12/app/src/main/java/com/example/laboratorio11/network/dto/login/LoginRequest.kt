package com.example.laboratorio11.network.dto.login

//Dto's son similares a los modelos de la base de datos
data class LoginRequest(
    val email: String,
    val password: String
)