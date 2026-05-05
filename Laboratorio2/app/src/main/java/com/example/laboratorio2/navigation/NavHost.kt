package com.example.laboratorio2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio2.views.PantallaHome
import com.example.laboratorio2.views.Sensores
import com.example.laboratorio2.views.app

@Preview(showBackground = true)
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            PantallaHome(navController)

        }
        composable<App> {
            app(navController)
        }
        composable<Sensores> {
            Sensores(navController)
        }

    }
}