package com.katiacammisa.paypal_interview.login

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun LoginScreen(
    navigateToSuccess: () -> Unit,
) {
    val viewModel = hiltViewModel<LoginViewModel>()

    val wrongCredentials by viewModel.wrongCredentials.collectAsStateWithLifecycle()

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column {

        AnimatedVisibility(wrongCredentials) {
            Text("Wrong credentials", color = Color.Red)
        }

        TextField(
            username,
            onValueChange = {
                username = it
            },
            placeholder = {
                Text("Username")
            }
        )

        TextField(
            password,
            onValueChange = {
                password = it
            },
            placeholder = {
                Text("Password")
            }
        )

        val context = LocalContext.current

        Button(
            onClick = {
                if (username.isNotBlank() && password.isNotBlank()) {
                    viewModel.submitLoginCredentials(username, password, navigateToSuccess)
                } else {
                    Toast.makeText(context, "Fields should not be empty", Toast.LENGTH_SHORT).show()
                }

            }
        ) {
            Text("Login")
        }
    }

}