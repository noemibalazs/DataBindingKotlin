package com.noemi.android.mykotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{

    companion object {
        val baseUrl: String = "https://reqres.in/api/"
        var retrofit: Retrofit? = null

        fun getInstance() : Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }
    }
}