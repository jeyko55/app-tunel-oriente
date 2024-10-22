package com.udea.apptuneloriente.presentation.screens.authentication.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.presentation.components.CustomButton
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    onEnterSelected: () -> Unit,
    onClickHereSelected: () -> Unit,
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> onEnterSelected()
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

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
            color = DarkElectricBlue,
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

        Spacer(modifier = Modifier.height(80.dp))

        TextField(
            placeholder = {
                Text(
                    text = stringResource(id = R.string.email_address),
                    color = DarkElectricBlue,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,

            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = DarkElectricBlue,
                focusedIndicatorColor = DarkElectricBlue,
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
                    color = DarkElectricBlue,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,

            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = DarkElectricBlue,
                focusedIndicatorColor = DarkElectricBlue,
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
            onClick = {
                authViewModel.login(email, password)
            },
            enabled = authState.value != AuthState.Loading,
            modifier = Modifier
                .height(48.dp)
                .width(220.dp),
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.forgot_password),
                color = DarkElectricBlue,
                fontFamily = jostFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
            )

            TextButton(
                onClick = {
                    authViewModel.login(email, password)
                    onClickHereSelected()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MariGold
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