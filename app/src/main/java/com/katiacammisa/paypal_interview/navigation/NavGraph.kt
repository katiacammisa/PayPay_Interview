package com.katiacammisa.paypal_interview.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.katiacammisa.paypal_interview.login.LoginScreen
import com.katiacammisa.paypal_interview.success.SuccessScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun NavHostComposable(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PayPalScreen.Login.name,
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(20.dp)
    ) {
        composable(route = PayPalScreen.Login.name) {
            LoginScreen(
                navigateToSuccess = {
                    navController.navigate(PayPalScreen.Success.name)
                }
            )
        }
        composable(route = PayPalScreen.Success.name) {
            SuccessScreen()
        }
    }
}