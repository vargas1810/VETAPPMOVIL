package com.fisi.vetmobile.network

@Serializable
data class LoginResponse(
    @SerialName("access_token")
    val accessToken: String,
    val message: String,
    val status: Int
)
