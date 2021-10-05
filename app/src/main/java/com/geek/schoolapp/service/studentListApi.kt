package com.geek.schoolapp.service

import com.geek.schoolapp.dataModel.studentX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface studentListApi {

    @GET("/api/userlist")
    suspend fun getStudentList(@Query("standard") standard : Any) : Response<studentX>

}