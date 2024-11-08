package com.fisi.vetmobile.ui.view

// MenuScreen.kt
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(onRegisterPetClick: () -> Unit, onViewPetsClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onRegisterPetClick, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text("Registrar Mascota")
        }
        Button(onClick = onViewPetsClick, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text("Ver Mascotas Registradas")
        }
    }
}
