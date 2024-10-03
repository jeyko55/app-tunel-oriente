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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.RotateLeft
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlaceholderVerticalAlign
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
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold
import kotlin.text.append

@Composable
fun ManagementScreen() {
    val jostFontFamily = FontFamily(
        Font(R.font.jost, FontWeight.Normal),
        Font(R.font.jost_bold, FontWeight.Bold)
    )

    val name = "mariacatalinac"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            jostFontFamily = jostFontFamily
        )

        RowItem(
            icon = Icons.Filled.RotateLeft,
            contentDescription = "Rotate Left",
            buttonText = "Consultar estado actual",
            jostFontFamily = jostFontFamily
        )

        RowItem(
            icon = Icons.Filled.History,
            contentDescription = "History",
            buttonText = "Ver historial de eventos",
            jostFontFamily = jostFontFamily
        )
    }
}

@Composable
fun RowItem(
    icon: ImageVector,
    contentDescription: String,
    buttonText: String,
    jostFontFamily: FontFamily,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Circle with icon
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
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Text button
        Button(
            onClick = { /* TODO: Handle button click */ },
            modifier = Modifier.height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MariGold
            )
        ) {
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