package com.example.testwork.servicoes

import com.example.testwork.models.JsonResult
import retrofit2.Call
import retrofit2.http.GET

interface APIServicoes {
    
    @GET("events")
    fun getDempEvents(): Call<List<JsonResult>>

}