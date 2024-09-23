package com.udea.apptuneloriente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.udea.apptuneloriente.navigation.TunnelApp
import com.udea.apptuneloriente.ui.theme.AppTunelOrienteActivity
import com.udea.apptuneloriente.ui.theme.AppTunelOrienteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTunelOrienteTheme {
                TunnelApp(

                )
            }
        }
    }
}
