package com.fisi.vetmobile.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VetMobileApiService {

    @POST("login")
    suspend fun verificarLogin(@Body loginRequest: LoginRequest): LoginResponse

    @GET("usuarios")
    suspend fun getUsuarios(): String

    @GET("usuarios/email/{username}")
    fun getEmail(@Path("email") email: String): String
}