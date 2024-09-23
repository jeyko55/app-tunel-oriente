package com.udea.apptuneloriente.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.udea.apptuneloriente.R

@Composable
fun WelcomeScreen(
    navController: NavHostController,
) {
    Box(modifier = Modifier) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier

                    .height(300.dp)


            )
            Text(text = stringResource(id = R.string.welcome))
        }
    }
}
