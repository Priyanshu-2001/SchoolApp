package com.geek.schoolapp.retrofitHelper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retroHelper_StudentList {
    val BASE_URL = "https://schoolapp1121.herokuapp.com"

    fun getInstance() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}