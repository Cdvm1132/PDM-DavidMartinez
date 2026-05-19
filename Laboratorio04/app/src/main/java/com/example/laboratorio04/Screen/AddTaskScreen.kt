package com.example.laboratorio04.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio04.Model.Task
import com.example.laboratorio04.ViewModel.GeneralViewModel
import com.example.laboratorio04.Model.Card

@Composable
fun AddTaskScreen(viewModel: GeneralViewModel, onBack: () -> Boolean) {

    val newCard = remember { mutableStateOf(Card()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Nueva Tarea",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = newCard.value.title,
            onValueChange = { newCard.value = newCard.value.copy(title = it) },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = newCard.value.description,
            onValueChange = { newCard.value = newCard.value.copy(description = it) },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )
        Button(onClick = {
            val task = Task(
                id          = newCard.value.pos,
                title       = newCard.value.title,
                description = newCard.value.description,
                endDate     = newCard.value.endDate,
                isCompleted = newCard.value.checked
            )
            viewModel.addTask(task)
            onBack()
        }) {
            Text("Agregar Tarea")
        }
    }
}