package com.katiacammisa.paypal_interview.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SuccessScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Successful login", fontSize = 40.sp)
    }
}