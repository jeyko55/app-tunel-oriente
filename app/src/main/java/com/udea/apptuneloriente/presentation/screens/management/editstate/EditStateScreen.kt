package com.udea.apptuneloriente.presentation.screens.management.editstate

import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MinorCrash
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.AccessTime // Importa el ícono de reloj
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Engineering
import androidx.compose.material.icons.filled.EscalatorWarning
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun EditStateScreen() {
    var selectedTime by remember { mutableStateOf("00:00:00") }
    var showTimePickerDialog by remember { mutableStateOf(false) }
    var showSecondsPickerDialog by remember { mutableStateOf(false) }
    var tempHour by remember { mutableStateOf(0) }
    var tempMinute by remember { mutableStateOf(0) }
    var tempSecond by remember { mutableStateOf(0) }
    var selectedReason by remember { mutableStateOf("Accidente") }
    var isAvailable by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                .width(318.dp)
                .padding(16.dp)
                .background(
                    color = MariGold,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isAvailable) "DISPONIBLE" else "NO DISPONIBLE",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = jostFontFamily,
                    fontStyle = FontStyle.Normal
                )

                IconButton(
                    onClick = {
                        isAvailable = !isAvailable
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Cambiar Disponibilidad",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "MOTIVO:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = jostFontFamily,
                fontStyle = FontStyle.Normal
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    RadioButton(
                        selected = selectedReason == "Accidente",
                        onClick = {
                            selectedReason = if (selectedReason == "Accidente") "" else "Accidente"
                        }
                    )
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

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    RadioButton(
                        selected = selectedReason == "Mantenimiento",
                        onClick = {
                            selectedReason = if (selectedReason == "Mantenimiento") "" else "Mantenimiento"
                        }
                    )
                    Icon(
                        imageVector = Icons.Default.Engineering,
                        contentDescription = "Mantenimiento",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Mantenimiento",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = jostFontFamily
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "TIEMPO ESTIMADO:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = jostFontFamily,
                fontStyle = FontStyle.Normal
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = selectedTime,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = jostFontFamily
                )

                IconButton(onClick = {
                    showTimePickerDialog = true
                }) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = "Seleccionar Hora",
                        tint = Color.White
                    )
                }
            }

            if (showTimePickerDialog) {
                TimePickerDialog(
                    context,
                    { _, hour, minute ->
                        tempHour = if (hour == 0) 24 else hour
                        tempMinute = minute
                        showTimePickerDialog = false
                        showSecondsPickerDialog = true
                    },
                    0, 0, true
                ).show()
            }

            if (showSecondsPickerDialog) {
                AlertDialog(
                    onDismissRequest = { showSecondsPickerDialog = false },
                    confirmButton = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            CustomButton(
                                text = "OK",
                                onClick = {
                                    selectedTime = String.format("%02d:%02d:%02d", tempHour, tempMinute, tempSecond)
                                    showSecondsPickerDialog = false
                                },
                                enabled = true,
                                fontWeight = FontWeight.Normal,
                                backgroundColor = MariGold,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                                    .padding(4.dp)
                            )
                            CustomButton(
                                text = "CANCELAR",
                                onClick = { showSecondsPickerDialog = false },
                                enabled = true,
                                fontWeight = FontWeight.Normal,
                                backgroundColor = MariGold,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                                    .padding(4.dp)
                            )
                        }
                    },
                    title = {
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "Seleccionar segundos",
                                fontFamily = jostFontFamily,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                color = DarkElectricBlue
                            )
                        }
                    },
                    text = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "$tempSecond segundos",
                                fontFamily = jostFontFamily,
                                fontStyle = FontStyle.Normal,
                                fontSize = 20.sp,
                                color = DarkElectricBlue
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Slider(
                                value = tempSecond.toFloat(),
                                onValueChange = { tempSecond = it.toInt() },
                                valueRange = 0f..59f,
                                steps = 59
                            )
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(100.dp))

        CustomButton(
            text = "GUARDAR",
            onClick = {
                Toast.makeText(context, "Evento guardado", Toast.LENGTH_SHORT).show()
            },
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .height(48.dp)
                .width(220.dp),
            fontSize = 20.sp,
        )
    }
}
