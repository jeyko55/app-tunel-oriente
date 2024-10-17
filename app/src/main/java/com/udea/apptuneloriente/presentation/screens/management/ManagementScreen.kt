package com.udea.apptuneloriente.presentation.screens.management

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.RotateLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.presentation.screens.authentication.login.AuthViewModel
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold


@Composable
fun ManagementScreen(
    authViewModel: AuthViewModel,
    managementViewModel: ManagementViewModel,
    onSignOutSelected: () -> Unit,
    onAddSelected: () -> Unit,
    onStateSelected: () -> Unit,
    // onHistorySelected: () -> Unit
) {
    val jostFontFamily = FontFamily(
        Font(R.font.jost, FontWeight.Normal),
        Font(R.font.jost_bold, FontWeight.Bold)
    )

    val events by managementViewModel.events.collectAsState()

    val errorState by managementViewModel.errorState.collectAsState()

    val name = authViewModel.userNameFromEmail.value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {
                authViewModel.signOut()   // Cerrar sesión
                onSignOutSelected()       // Redirigir al usuario a la pantalla de login
            },
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.End)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = MariGold,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = "Cerrar sesión",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = DarkElectricBlue)) {
                    append("¡Hola, ")
                }
                withStyle(style = SpanStyle(color = MariGold)) {
                    append(name)
                }
                withStyle(style = SpanStyle(color = DarkElectricBlue)) {
                    append("!")
                }
            },
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.height(100.dp))

        RowItem(
            icon = Icons.Filled.Add,
            contentDescription = "Add",
            buttonText = "Añadir nuevo elemento",
            jostFontFamily = jostFontFamily,
            onClick = { onAddSelected() }
        )

        RowItem(
            icon = Icons.Filled.RotateLeft,
            contentDescription = "Rotate Left",
            buttonText = "Consultar estado actual",
            jostFontFamily = jostFontFamily,
            onClick = { onStateSelected() }
        )

        RowItem(
            icon = Icons.Filled.History,
            contentDescription = "History",
            buttonText = "Ver historial de eventos",
            jostFontFamily = jostFontFamily,
            onClick = { /* TODO: Handle button click */ }
        )
    }
}


@Composable
fun RowItem(
    icon: ImageVector,
    contentDescription: String,
    buttonText: String,
    jostFontFamily: FontFamily,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MariGold
        ),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = MariGold,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = buttonText,
                color = DarkElectricBlue,
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        }
    }
}