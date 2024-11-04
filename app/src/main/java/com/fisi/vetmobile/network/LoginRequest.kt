package com.fisi.vetmobile.network

data class LoginRequest(
    val username: String,
    val password_hash: String
)
