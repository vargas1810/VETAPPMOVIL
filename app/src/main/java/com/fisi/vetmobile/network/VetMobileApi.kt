package com.fisi.vetmobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL =
    "https://vetmobilebackend.onrender.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object VetMobileApi {
    val retrofitService: VetMobileApiService by lazy {
        retrofit.create(VetMobileApiService::class.java)
    }
}

