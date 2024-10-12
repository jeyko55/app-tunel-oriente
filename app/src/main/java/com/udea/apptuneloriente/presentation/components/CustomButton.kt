package com.udea.apptuneloriente.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.apptuneloriente.R
import com.udea.apptuneloriente.ui.theme.MariGold

@Composable
fun CustomButton(text: String, onClick: () -> Unit, enabled: Boolean = true, fontWeight: FontWeight = FontWeight.Normal, backgroundColor: Color = MariGold) {

    val jostFontFamily = FontFamily(
        Font(R.font.jost, FontWeight.Normal),
        Font(R.font.jost_bold, FontWeight.Bold)
    )

    Button(
        onClick = onClick,
        modifier = Modifier
            .height(48.dp)
            .width(220.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.white),
            fontFamily = jostFontFamily,
            fontWeight = fontWeight,
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp,
        )
    }
}
