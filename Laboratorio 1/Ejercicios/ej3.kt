package com.example.prueba
import org.junit.Test

class Ejercicio3 {

    data class Estudiante(
        val nombre: String,
        val carnet: String,
        val asignatura: String
    )

    @Test
    fun main() {
        val Ciclo01 = listOf(
            Estudiante("David", "001", "Programacion de Dispositivos Moviles"),
            Estudiante("Sayuri", "002", "Programacion de Dispositivos Moviles"),
            Estudiante("Goku", "003", "Programacion de Dispositivos Moviles"),
            Estudiante("Juan", "004", "Analisis numerico"),
            Estudiante("Josue", "005", "Analisis numerico"),
            Estudiante("Eduardo", "006", "Analisis numerico"),
            Estudiante("Sayuri", "007", "Analisis numerico")
        )
        val moviles = Ciclo01.filter {
            it.asignatura == "Programacion de Dispositivos Moviles"
        }
        println("Estudiantes en Dispositivos Moviles:")
        moviles.forEach {
            println("${it.nombre} - ${it.carnet}")
        }
    }
}
