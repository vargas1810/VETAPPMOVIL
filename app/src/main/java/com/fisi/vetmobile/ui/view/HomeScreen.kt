package com.fisi.vetmobile.ui.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fisi.vetmobile.ui.components.SysVitaTopBar
import com.fisi.vetmobile.ui.theme.VetMobileTheme

@Composable
fun HomeScreen(onLoginClick: () -> Unit) {
    //var esEspecialista = false
    Scaffold(topBar = {
        SysVitaTopBar(
            canNavigateBack = false,
            navigateUp = {},
            title = "Universidad Nacional Mayor de San Marcos"
        )
    }, bottomBar = {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(height = 55.dp, width = 395.dp)
        ) {

        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(top = 36.dp, bottom = 36.dp),
                text = "SysVita",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            val imagePainter = painterResource(id = R.drawable.sysvita_launcher_foreground)
            Image(
                painter = imagePainter,
                contentDescription = "Icono Sysvita",
                modifier = Modifier.size(100.dp)
            )

            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 30.dp)
                    .size(width = 200.dp, height = 40.dp)
            ) {
                Text("Usuario", fontSize = 17.sp)
            }


            FilledTonalButton(
                onClick = onLoginClick,
                modifier = Modifier.size(width = 200.dp, height = 40.dp)
            ) {
                Text("Especialista", fontSize = 17.sp)
            }


        }
    }

}

@Preview
@Composable
fun PreviewLayout() {
    VetMobileTheme(darkTheme = false) {
        HomeScreen(onLoginClick = {})
    }
}