package com.udea.apptuneloriente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.udea.apptuneloriente.presentation.ui.navigation.NavGraph
import com.udea.apptuneloriente.presentation.ui.theme.AppTunelOrienteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTunelOrienteTheme {
                NavGraph(

                )
            }
        }
    }
}
