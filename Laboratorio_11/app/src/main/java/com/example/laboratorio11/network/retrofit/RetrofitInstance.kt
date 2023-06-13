package com.example.laboratorio11.network.retrofit

import com.example.laboratorio11.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://retrofit.up.railway.app/"

object RetrofitInstance {

    // a variable to store the token
    private var TOKEN = ""

    // a function to set the token

    fun setToken(token: String) {
        this.TOKEN = token
    }

    // a instance of Retrofit

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // a function to get the login service from the Retrofit instance

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}