package com.fisi.vetmobile.data.repository

import com.fisi.vetmobile.network.LoginResponse

interface LoginRepository {
    suspend fun verificarLogin(username: String, password: String): List<LoginResponse>
}