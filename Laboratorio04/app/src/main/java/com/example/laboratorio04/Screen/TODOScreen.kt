package com.example.laboratorio04.Screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laboratorio04.Model.Card
import com.example.laboratorio04.ViewModel.GeneralViewModel

@Composable
fun TODOScreen(viewModel: GeneralViewModel, navController: NavController) {

    val tasks = viewModel.tasks.collectAsState()

    val lista = mutableListOf<Card>()

    tasks.value.forEach { task ->
        Log.d("Task", task.toString())
        lista.add(
            Card(
                pos = task.id,
                title = task.title,
                description = task.description,
                endDate = task.endDate,
                checked = task.isCompleted
            )
        )
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") }) {
                Text("Agregar")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(lista) { card ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = card.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = card.description, style = MaterialTheme.typography.bodySmall)
                        Text(text = "Vence: ${card.endDate}", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}