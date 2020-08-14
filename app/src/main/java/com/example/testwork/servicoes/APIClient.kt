package com.example.testwork.servicoes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIClient {

    private var retrofit:Retrofit? = null
    fun getClient():Retrofit{
        if (retrofit == null){
            retrofit  =  Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }



}