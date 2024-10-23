package com.udea.apptuneloriente.presentation.navigation

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udea.apptuneloriente.presentation.screens.authentication.login.AuthViewModel
import com.udea.apptuneloriente.presentation.screens.authentication.login.LoginScreen
import com.udea.apptuneloriente.presentation.screens.authentication.recoverpassword.RecoverPasswordScreen
import com.udea.apptuneloriente.presentation.screens.homescreen.HomeScreen
import com.udea.apptuneloriente.presentation.screens.initial.InitialScreen
import com.udea.apptuneloriente.presentation.screens.management.ManagementScreen
import com.udea.apptuneloriente.presentation.screens.management.ManagementViewModel
import com.udea.apptuneloriente.presentation.screens.management.addevent.AddEventScreen
import com.udea.apptuneloriente.presentation.screens.management.editstate.EditStateScreen
import com.udea.apptuneloriente.presentation.screens.management.stateadmin.StateAdminScreen

@Composable
fun NavGraph(
    authViewModel: AuthViewModel,
    managementViewModel: ManagementViewModel,

    ) {
    val navController: NavHostController = rememberNavController()
    val context = LocalContext.current

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

                )
            }
            composable(route = Routes.HOME_SCREEN) {
                HomeScreen(
                    onRoutesSelected = {
                        val gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Túnel+de+Oriente")  // URL de Google Maps
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")

                        // Verifica si hay una aplicación que pueda manejar el Intent
                        if (mapIntent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(mapIntent)
                        } else {
                            Toast.makeText(context, "Google Maps no está instalado", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
            composable(route = Routes.MANAGEMENT_SCREEN) {
                ManagementScreen (
                    authViewModel,
                    managementViewModel,
                    onSignOutSelected = {
                        navController.navigate(Routes.LOGIN_SCREEN)
                    },
                    onAddSelected = {
                        navController.navigate(Routes.ADD_EVENT_SCREEN)
                    },
                    onStateSelected = {
                        navController.navigate(Routes.STATE_ADMIN_SCREEN)
                    },
                    /* onHistorySelected = {
                        navController.navigate(Routes.HISTORY_SCREEN)
                    }
                    */
                )
            }
            composable(route = Routes.ADD_EVENT_SCREEN) {
                AddEventScreen(
                    managementViewModel,
                )
            }
            composable(route = Routes.STATE_ADMIN_SCREEN) {
                StateAdminScreen(
                    onEndSelected = {

                    },
                    onEditSelected = {
                        navController.navigate(Routes.EDIT_STATE_SCREEN)
                    }
                )
            }
            composable(route = Routes.EDIT_STATE_SCREEN) {
                EditStateScreen(

                )
            }
            // composable("recover_password") { RecoverPasswordScreen(navController) }
            // Más pantallas...
        }
    )
}