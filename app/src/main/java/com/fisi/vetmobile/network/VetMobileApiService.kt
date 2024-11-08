package com.fisi.vetmobile.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VetMobileApiService {

    @POST("mascotas")
    fun createMascota(@Body mascota: Mascota): Call<Mascota>

    @GET("mascotas")
    fun getMascotas(): Call<List<Mascota>>

    @GET("mascotas/usuario")
    fun getMascotasByUsuario(@Query("id_usuario") idUsuario: Int): Call<List<Mascota>>

    @GET("mascota")
    fun getMascotaByUsuarioAndNombre(
        @Query("id_usuario") idUsuario: Int,
        @Query("nombre") nombre: String
    ): Call<Mascota>

    @PUT("mascotas/{id_mascota}")
    fun updateMascota(
        @Path("id_mascota") idMascota: Int,
        @Body mascota: Mascota
    ): Call<Mascota>

    @DELETE("mascotas/{id_mascota}")
    fun deleteMascota(@Path("id_mascota") idMascota: Int): Call<Void>

    @POST("login")
    suspend fun verificarLogin(@Body loginRequest: LoginRequest): LoginResponse

    @GET("usuarios")
    suspend fun getUsuarios(): String

    @GET("usuarios/email/{username}")
    fun getEmail(@Path("email") email: String): String
}