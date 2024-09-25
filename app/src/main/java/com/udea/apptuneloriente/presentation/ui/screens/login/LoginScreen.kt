package com.udea.apptuneloriente.presentation.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.presentation.ui.components.CustomButton
import com.udea.apptuneloriente.presentation.ui.navigation.Routes

@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

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

        Text(
            text = stringResource(id = R.string.login),
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

        Spacer(modifier = Modifier.height(80.dp))

        TextField(
            placeholder = {
                Text(
                    text = stringResource(id = R.string.email_address),
                    color = colorResource(id = R.color.dark_electric_blue),
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,

            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = colorResource(id = R.color.dark_electric_blue),
                focusedIndicatorColor = colorResource(id = R.color.dark_electric_blue),
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            value = email,
            onValueChange = {
                email = it
            },
        )

        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            placeholder = {
                Text(
                    text = stringResource(id = R.string.password),
                    color = colorResource(id = R.color.dark_electric_blue),
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,

            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = colorResource(id = R.color.dark_electric_blue),
                focusedIndicatorColor = colorResource(id = R.color.dark_electric_blue),
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            value = password,
            onValueChange = {
                password = it
            },
        )

        Spacer(modifier = Modifier.height(90.dp))

        CustomButton(
            text = stringResource(id = R.string.enter),
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.forgot_password),
                color = colorResource(id = R.color.dark_electric_blue),
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
            )

            TextButton(
                onClick = { navController.navigate(
                    Routes.RECOVER_PASSWORD_SCREEN) },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = colorResource(id = R.color.marigold)
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.click_here),
                    fontFamily = jostFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp
                )
            }
        }
    }
}