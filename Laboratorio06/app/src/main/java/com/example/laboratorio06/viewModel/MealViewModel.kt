package com.example.laboratorio06.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio06.data.model.Meal
import com.example.laboratorio06.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {
    var meals by mutableStateOf<List<Meal>>(emptyList())
    private set

    var isLoading by mutableStateOf(false)

    fun loadMeals() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitInstance.api.getMeals()
                meals = response.meals ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}
