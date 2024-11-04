package com.fisi.vetmobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun VetMobileApp(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel = viewModel()
) {

    NavHost(
        navController = navController,
        startDestination = VetMobileScreen.Home.name,
    ) {
        composable(route = VetMobileScreen.Home.name) {
            HomeScreen(onLoginClick = { navController.navigate(VetMobileScreen.Login.name) })
        }
        composable(route = VetMobileScreen.Login.name) {
            LoginScreen(loginViewModel)
        }
    }
}