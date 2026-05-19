package com.example.laboratorio04.Model

import java.util.Date

data class Card(
    val pos: Int = 0,
    val title: String = "",
    val description: String = "",
    val endDate: Date = Date(),
    val checked: Boolean = false
)