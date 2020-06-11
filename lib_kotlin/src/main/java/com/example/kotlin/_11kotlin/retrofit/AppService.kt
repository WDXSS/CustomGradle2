package com.example.kotlin._11kotlin.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface AppService {
    @GET("/get_data.json")
    fun getAppDate():Call<List<AppData>>
}