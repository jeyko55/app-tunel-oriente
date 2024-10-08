package com.udea.apptuneloriente.presentation.screens.recoverpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.presentation.components.CustomButton
import com.udea.apptuneloriente.presentation.screens.login.AuthViewModel
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold

@Composable
fun RecoverPasswordScreen(
    authViewModel: AuthViewModel = viewModel(),
) {
    var email by remember { mutableStateOf("") }
    val emailSent by authViewModel.emailSent
    val errorMessage by authViewModel.errorMessage



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
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.recover_password),
            color = DarkElectricBlue,
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
            lineHeight = 40.sp,
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

        Box(
            modifier = Modifier.width(220.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.recover_password_text),
                    color = MariGold,
                    fontFamily = jostFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.height(8.dp))

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
            }

        }

        Spacer(modifier = Modifier.height(90.dp))

        CustomButton(
            text = stringResource(id = R.string.send),
            onClick = {
                authViewModel.recoverPassword(email)

            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar mensajes de éxito o error
        if (emailSent) {
            Text(
                text = "Correo de recuperación enviado. Revisa tu bandeja de entrada.",
                color = Color.Green,
                textAlign = TextAlign.Center
            )
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }
    }
}

