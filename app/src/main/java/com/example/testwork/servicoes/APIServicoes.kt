package com.example.testwork.servicoes

import com.example.testwork.models.JsonResult
import com.example.testwork.models.UserName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIServicoes {

    @GET("events")
    fun getDempEvents(): Call<List<JsonResult>>

    @GET("users/{name}")
    fun getUserName(@Path("name") name: String): Call<UserName>


}