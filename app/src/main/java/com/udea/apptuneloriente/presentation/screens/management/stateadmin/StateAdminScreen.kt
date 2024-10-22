package com.udea.apptuneloriente.presentation.screens.management.stateadmin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MinorCrash
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.udea.apptuneloriente.presentation.screens.authentication.login.AuthState
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold

@Composable
fun StateAdminScreen(
    onEndSelected: () -> Unit,
    onEditSelected: () -> Unit
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

        Text(
            text = "TÚNEL ORIENTE",
            color = DarkElectricBlue,
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
        )

        Spacer(modifier = Modifier.height(80.dp))

        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(16.dp)
                .background(
                    color = MariGold,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "NO DISPONIBLE",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = jostFontFamily,
                fontStyle = FontStyle.Normal
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "MOTIVO:",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = jostFontFamily,
                    fontStyle = FontStyle.Normal
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.MinorCrash,
                        contentDescription = "Accidente",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Accidente",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = jostFontFamily
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "TIEMPO ESTIMADO:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = jostFontFamily,
                fontStyle = FontStyle.Normal
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "00:00:00",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = jostFontFamily
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        CustomButton(
            text = "TERMINAR",
            fontWeight = FontWeight.Bold,
            onClick = { onEndSelected() },
            modifier = Modifier
                .height(48.dp)
                .width(220.dp),
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(15.dp))

        CustomButton(
            text = "EDITAR",
            fontWeight = FontWeight.Bold,
            backgroundColor = DarkElectricBlue,
            onClick = { onEditSelected() },
            modifier = Modifier
                .height(48.dp)
                .width(220.dp),
            fontSize = 20.sp,
        )
    }
}