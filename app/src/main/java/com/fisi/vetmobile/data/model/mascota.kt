package com.fisi.vetmobile.data.model

data class Mascota(
    val id_usuario: Int,
    val nombre: String,
    val especie: String,
    val raza: String,
    val edad: Int,
    val peso: Float,
    val genero: String
)
