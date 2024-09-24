package com.udea.apptuneloriente.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udea.apptuneloriente.ui.auth.LoginScreen
import com.udea.apptuneloriente.ui.auth.WelcomeScreen

@Composable
fun TunnelApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME_SCREEN,
        builder = {
            composable(route = Routes.WELCOME_SCREEN) {
                WelcomeScreen(
                    navController
                )
            }
            composable(route = Routes.LOGIN_SCREEN) {
                LoginScreen(
                    navController
                )
            }
            // composable("recover_password") { RecoverPasswordScreen(navController) }
            // Más pantallas...
        }
    )
}