package com.udea.apptuneloriente.presentation.screens.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.presentation.components.CustomButton
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold

@Composable
fun InitialScreen(
    onEnterSelected: () -> Unit,
    onEnterHereSelected: () -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        val jostFontFamily = FontFamily(
            Font(R.font.jost, FontWeight.Normal),
            Font(R.font.jost_bold, FontWeight.Bold)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(100.dp)
                .width(92.dp)
        )

        Text(
            text = stringResource(id = R.string.welcome),
            color = MariGold,
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
        )

        Text(
            text = stringResource(id = R.string.tunel_oriente),
            color = MariGold,
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.width(350.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.text_welcome_screen),
                color = DarkElectricBlue,
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        CustomButton(
            text = stringResource(id = R.string.enter),
            onClick = { onEnterSelected() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.are_you_admin),
                color = DarkElectricBlue,
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
            )

            TextButton(
                onClick = { onEnterHereSelected() },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MariGold
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.enter_here),
                    fontFamily = jostFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp
                )
            }
        }
    }
}
