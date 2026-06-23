package com.example.laboratorio06.data.model
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)
data class MealResponse(
    val meals: List<Meal>?
)