package com.fisi.vetmobile.network

interface VetMobileApiService {

    @POST("login")
    suspend fun verificarLogin(@Body loginRequest: LoginRequest): LoginResponse

    @GET("usuarios")
    suspend fun getUsuarios(): String

    @GET("usuarios/email/{username}")
    fun getEmail(@Path("email") email: String): String
}