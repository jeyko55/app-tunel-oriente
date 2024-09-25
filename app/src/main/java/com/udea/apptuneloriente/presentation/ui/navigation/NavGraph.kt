package com.udea.apptuneloriente.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udea.apptuneloriente.presentation.ui.screens.login.LoginScreen
import com.udea.apptuneloriente.presentation.ui.screens.recoverpassword.RecoverPasswordScreen
import com.udea.apptuneloriente.presentation.ui.screens.welcome.WelcomeScreen

@Composable
fun NavGraph() {
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
            composable(route = Routes.RECOVER_PASSWORD_SCREEN) {
                RecoverPasswordScreen(
                    navController
                )
            }
            // composable("recover_password") { RecoverPasswordScreen(navController) }
            // Más pantallas...
        }
    )
}