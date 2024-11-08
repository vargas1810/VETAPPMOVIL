package com.fisi.vetmobile.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.fisi.vetmobile.data.model.Mascota
import com.fisi.vetmobile.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ViewPetsScreen() {
    var mascotas by remember { mutableStateOf(listOf<Mascota>()) }

    LaunchedEffect(Unit) {
        RetrofitInstance.retrofitService.getMascotasByUsuario(1).enqueue(object : Callback<List<Mascota>> {
            override fun onResponse(call: Call<List<Mascota>>, response: Response<List<Mascota>>) {
                if (response.isSuccessful) {
                    mascotas = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Mascota>>, t: Throwable) {
                // Manejo de error
            }
        })
    }

    LazyColumn {
        items(mascotas) { mascota ->
            Text("Nombre: ${mascota.nombre}, Especie: ${mascota.especie}")
        }
    }
}
