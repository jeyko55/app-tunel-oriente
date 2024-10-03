package com.udea.apptuneloriente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.udea.apptuneloriente.presentation.navigation.NavGraph
import com.udea.apptuneloriente.presentation.screens.login.AuthViewModel
import com.udea.apptuneloriente.ui.theme.AppTunelOrienteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authViewModel: AuthViewModel by viewModels()
        setContent {
            AppTunelOrienteTheme {
                NavGraph(authViewModel = authViewModel)
            }
        }
    }
}
