package com.fisi.vetmobile.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fisi.vetmobile.ui.theme.VetMobileTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    loginUIConexion: ConexionUIState = ConexionUIState.Success
) {
    val loginUiState by loginViewModel.uiState.collectAsState()
    Scaffold(topBar = {
        SysVitaTopBar(canNavigateBack = false, title = "Login")
    }, bottomBar = {
        SysVitaBottomBar()
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (loginUIConexion) {
                is ConexionUIState.Success -> {

                }

                is ConexionUIState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
                is ConexionUIState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
            }
            val imagePainter = painterResource(id = R.drawable.sysvita_launcher_foreground)
            Image(
                painter = imagePainter,
                contentDescription = "Icono Sysvita",
                modifier = Modifier.size(100.dp)
            )

            Row {
                Text(text = "Email", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = loginViewModel.email,
                    onValueChange = { loginViewModel.email = it },
                    trailingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    keyboardActions = KeyboardActions(onDone = { }),
                    singleLine = true
                )
            }



            Row {
                Text(text = "Contraseña", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = loginViewModel.contrasena,
                    onValueChange = { loginViewModel.contrasena = it },
                    trailingIcon = { Icon(Icons.Default.Lock, contentDescription = "Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    keyboardActions = KeyboardActions(onDone = { }),
                    singleLine = true
                )
            }

            Button(onClick = {
                loginViewModel.validarLogin(
                    email = loginViewModel.email,
                    contrasena = loginViewModel.contrasena
                )
            }
            )
            { Text(text = "Iniciar Sesion", fontSize = 11.sp, fontWeight = FontWeight.Bold) }


            Text(
                text = loginUiState.isLoginSuccesfull.toString(),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    VetMobileTheme(darkTheme = false) {
        LoginScreen()
    }
}