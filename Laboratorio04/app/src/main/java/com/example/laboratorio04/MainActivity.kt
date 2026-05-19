package com.example.laboratorio04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio04.Screen.AddTaskScreen
import com.example.laboratorio04.Screen.TODOScreen
import com.example.laboratorio04.ViewModel.GeneralViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
   AppNavigation()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: GeneralViewModel = viewModel()

    NavHost(navController = navController, startDestination = "todo") {

        composable("todo") {
            TODOScreen(viewModel = viewModel, navController = navController)
        }

        composable("add") {
            AddTaskScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}