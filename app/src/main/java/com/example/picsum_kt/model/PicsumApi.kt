package com.example.picsum_kt.model

import retrofit2.Call
import retrofit2.http.GET

interface PicsumApi {

    @GET("list")
    fun getPicsum(): Call<List<Picsum>>
}