package com.fisi.vetmobile.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fisi.vetmobile.ui.view.HomeScreen
import com.fisi.vetmobile.ui.view.LoginScreen
import com.fisi.vetmobile.ui.viewmodel.LoginViewModel
import com.fisi.vetmobile.ui.view.*
import androidx.navigation.compose.composable

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
            LoginScreen(loginViewModel) {
                navController.navigate(VetMobileScreen.Menu.name) // Navega al menú después de iniciar sesión
            }
        }
        composable(route = VetMobileScreen.Menu.name) {
            MenuScreen(
                onRegisterPetClick = { navController.navigate(VetMobileScreen.RegisterPet.name) },
                onViewPetsClick = { navController.navigate(VetMobileScreen.ViewPets.name) }
            )
        }
        composable(route = VetMobileScreen.RegisterPet.name) {
            RegisterPetScreen(navController)
        }
        composable(route = VetMobileScreen.ViewPets.name) {
            ViewPetsScreen()
        }
    }
}