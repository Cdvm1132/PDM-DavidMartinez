package com.example.laboratorio06.data.remote

import com.example.laboratorio06.data.model.MealResponse
import retrofit2.http.GET
interface ApiService {

    @GET("search.php?s=")
    suspend fun getMeals(): MealResponse

}