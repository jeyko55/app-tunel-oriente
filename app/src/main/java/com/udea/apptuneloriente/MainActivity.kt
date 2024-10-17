package com.udea.apptuneloriente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.udea.apptuneloriente.data.repository.eventrepository.EventRepository
import com.udea.apptuneloriente.data.repository.userrepository.UserRepository
import com.udea.apptuneloriente.presentation.navigation.NavGraph
import com.udea.apptuneloriente.presentation.screens.authentication.login.AuthViewModel
import com.udea.apptuneloriente.presentation.screens.management.ManagementViewModel
import com.udea.apptuneloriente.ui.theme.AppTunelOrienteTheme

class MainActivity : ComponentActivity() {
    private val userRepository = UserRepository()
    private val eventRepository = EventRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authViewModel = AuthViewModel(userRepository)
        val managementViewModel = ManagementViewModel(eventRepository)

        setContent {
            AppTunelOrienteTheme {
                NavGraph(
                    authViewModel = authViewModel,
                    managementViewModel = managementViewModel,
                )
            }
        }
    }
}
