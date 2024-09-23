package com.udea.apptuneloriente.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.ui.components.CustomButton

@Composable
fun WelcomeScreen(
    navController: NavHostController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
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
            color = colorResource(id = R.color.dark_electric_blue),
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
        )

        Text(
            text = stringResource(id = R.string.tunel_oriente),
            color = colorResource(id = R.color.marigold),
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
                color = colorResource(id = R.color.dark_electric_blue),
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        CustomButton(text = stringResource(id = R.string.enter), onClick = {})

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.are_you_admin),
                color = colorResource(id = R.color.dark_electric_blue),
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
            )

            TextButton(
                onClick = { /* Your click action here */ },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = colorResource(id = R.color.marigold)
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.enter_here),
                    fontFamily = jostFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp
                )
            }
        }
    }
}
