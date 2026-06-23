package com.example.laboratorio06.ui.theme.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio06.data.model.Meal
import com.example.laboratorio06.viewModel.MealViewModel

@Composable
fun MealScreen (
    viewModel: MealViewModel = viewModel(),
    meals: List<Meal> = viewModel.meals,
    isLoading: Boolean = viewModel.isLoading
)
{
    LaunchedEffect(Unit) {
        viewModel.loadMeals()
    }
    when{
        isLoading -> CircularProgressIndicator()
        else -> {
            LazyColumn{
                items(viewModel.meals){meal ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {  Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = meal.strMeal
                        )
                        Text(
                            text = meal.strCategory
                        )
                        Text(
                            text = meal.strArea
                        )
                    }
                    }
                }
            }
            }

    }
}

