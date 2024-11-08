package com.fisi.vetmobile.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fisi.vetmobile.data.model.Mascota
import com.fisi.vetmobile.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun RegisterPetScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var especie by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = especie, onValueChange = { especie = it }, label = { Text("Especie") })
        TextField(value = raza, onValueChange = { raza = it }, label = { Text("Raza") })
        TextField(value = edad, onValueChange = { edad = it }, label = { Text("Edad") })
        TextField(value = peso, onValueChange = { peso = it }, label = { Text("Peso") })
        TextField(value = genero, onValueChange = { genero = it }, label = { Text("Género") })

        Button(onClick = {
            val mascota = Mascota(1, nombre, especie, raza, edad.toInt(), peso.toFloat(), genero)
            RetrofitInstance.retrofitService.createMascota(mascota).enqueue(object : Callback<Mascota> {
                override fun onResponse(call: Call<Mascota>, response: Response<Mascota>) {
                    if (response.isSuccessful) {
                        navController.popBackStack() // Regresar al menú principal
                    }
                }

                override fun onFailure(call: Call<Mascota>, t: Throwable) {
                    // Manejo de error
                }
            })
        }) {
            Text("Registrar Mascota")
        }
    }
}

