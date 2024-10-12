package com.udea.apptuneloriente.presentation.screens.addevent

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
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
import com.udea.apptuneloriente.presentation.screens.login.AuthState
import com.udea.apptuneloriente.ui.theme.DarkElectricBlue
import com.udea.apptuneloriente.ui.theme.MariGold
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventScreen() {
    var type by remember { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    val options = listOf("Accidente", "Mantenimiento")

    var date by remember { mutableStateOf("") }
    val context = LocalContext.current

    var time by remember { mutableStateOf("") }

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
            text = "Agregar evento",
            color = DarkElectricBlue,
            fontFamily = jostFontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
        )

        Spacer(modifier = Modifier.height(80.dp))

        ExposedDropdownMenuBox(
            expanded = isDropdownExpanded,
            onExpandedChange = { isDropdownExpanded = !isDropdownExpanded }
        ) {
            TextField(
                readOnly = true,
                value = type,
                onValueChange = {},
                label = {
                    Text(
                        text = "Tipo",
                        fontFamily = jostFontFamily,
                        fontStyle = FontStyle.Normal,
                        fontSize = 20.sp,
                        color = DarkElectricBlue
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded)
                },
                textStyle = (LocalTextStyle.current.copy(color = DarkElectricBlue, fontSize = 20.sp)),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = DarkElectricBlue,
                    focusedIndicatorColor = DarkElectricBlue,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                ),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isDropdownExpanded,
                onDismissRequest = { isDropdownExpanded = false }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                selectionOption,
                                fontFamily = jostFontFamily,
                                fontStyle = FontStyle.Normal,
                                color = DarkElectricBlue,
                                fontSize = 20.sp
                            )
                        },
                        onClick = {
                            type = selectionOption
                            isDropdownExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            value = date,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(text = "Fecha inicio", color = DarkElectricBlue, fontSize = 20.sp) },
            modifier = Modifier,
            textStyle = (LocalTextStyle.current.copy(color = DarkElectricBlue, fontSize = 20.sp)),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = DarkElectricBlue,
                focusedIndicatorColor = DarkElectricBlue,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            trailingIcon = {
                IconButton(onClick = {
                    val calendar = Calendar.getInstance()
                    DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            date = "$dayOfMonth/${month + 1}/$year"
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }) {
                    Icon(Icons.Default.CalendarToday, contentDescription = "Select Date")
                }
            }
        )

        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            value = time,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(text = "Tiempo estimado", color = DarkElectricBlue, fontSize = 20.sp) },
            modifier = Modifier,
            textStyle = (LocalTextStyle.current.copy(color = DarkElectricBlue, fontSize = 20.sp)),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = DarkElectricBlue,
                focusedIndicatorColor = DarkElectricBlue,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            trailingIcon = {
                IconButton(onClick = {
                    val calendar = Calendar.getInstance()
                    TimePickerDialog(
                        context,
                        { _, hourOfDay, minute ->
                            time = "%02d:%02d:%02d".format(hourOfDay, minute, 0)
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                    ).show()
                }) {
                    Icon(Icons.Default.AccessTime, contentDescription = "Select Time")
                }
            }
        )

        Spacer(modifier = Modifier.height(95.dp))

        CustomButton(
            text = "GUARDAR",
            onClick = {
                // Implementar la lógica para guardar el evento
                Toast.makeText(context, "Evento guardado", Toast.LENGTH_SHORT).show()
            },
        )
    }
}