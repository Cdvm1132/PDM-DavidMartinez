package com.example.prueba
import org.junit.Test

class Ejercicio2 {

    class Calculadora(
        val marca: String,
        val vidaUtil: Int,
        var precio: Double
    ) {
        fun sumar(a: Double, b: Double): Double {
            val resultado = a + b
            println("[$marca - $vidaUtil de vida util] Suma: $resultado | Precio: $$precio")
            return resultado
        }
        fun restar(a: Double, b: Double): Double {
            val resultado = a - b
            println("[$marca] Resta: $resultado")
            return resultado
        }
        fun multiplicar(a: Double, b: Double): Double {
            val resultado = a * b
            println("[$marca] Multiplicacion: $resultado")
            return resultado
        }
        fun dividir(a: Double, b: Double): Double {
            if (b == 0.0) {
               println("santo cielo no puedes dividir entre 0")
            }
            val resultado = a / b
            println("[$marca] Division: $resultado")
            return resultado
        }
    }
    @Test
    fun main() {
        val calc = Calculadora("CASIO fx-991 LA CW", 5, 25.99)
        println("Suma: ${calc.sumar(10.0, 5.0)}")
        println("Resta: ${calc.restar(10.0, 5.0)}")
        println("Multiplicacion: ${calc.multiplicar(10.0, 5.0)}")
        try {
            println("Division: ${calc.dividir(10.0, 0.0)}")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}