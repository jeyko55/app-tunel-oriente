package com.udea.apptuneloriente.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udea.apptuneloriente.presentation.screens.homescreen.HomeScreen
import com.udea.apptuneloriente.presentation.screens.initial.InitialScreen
import com.udea.apptuneloriente.presentation.screens.login.AuthViewModel
import com.udea.apptuneloriente.presentation.screens.login.LoginScreen
import com.udea.apptuneloriente.presentation.screens.recoverpassword.RecoverPasswordScreen
import com.udea.apptuneloriente.presentation.screens.management.ManagementScreen

@Composable
fun NavGraph(
    authViewModel: AuthViewModel,
) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.INITIAL_SCREEN,
        builder = {
            composable(route = Routes.INITIAL_SCREEN) {
                InitialScreen(
                    onEnterSelected = {
                         navController.navigate(Routes.HOME_SCREEN)
                    },
                    onEnterHereSelected = {
                        navController.navigate(Routes.LOGIN_SCREEN)
                    }
                )
            }
            composable(route = Routes.LOGIN_SCREEN) {
                LoginScreen(
                    authViewModel,
                    onEnterSelected = {
                         navController.navigate(Routes.MANAGEMENT_SCREEN)
                    },
                    onClickHereSelected = {
                        navController.navigate(Routes.RECOVER_PASSWORD_SCREEN)
                    },
                )
            }
            composable(route = Routes.RECOVER_PASSWORD_SCREEN) {
                RecoverPasswordScreen(
                    onSendSelected = {
                         navController.navigate(Routes.LOGIN_SCREEN)
                    }
                )
            }
            composable(route = Routes.HOME_SCREEN) {
                HomeScreen(

                )
            }
            composable(route = Routes.MANAGEMENT_SCREEN) {
                ManagementScreen (

                )
            }
            // composable("recover_password") { RecoverPasswordScreen(navController) }
            // Más pantallas...
        }
    )
}