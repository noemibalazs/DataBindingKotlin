package com.noemi.android.mykotlin.network

import com.noemi.android.mykotlin.model.ItemList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getListItems(): Call<ItemList>

}