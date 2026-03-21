package com.example.prueba
import org.junit.Test

class Ejercicio1 {

    class Programa(
        val nombre: String
    )

    class Computadora(
        var marca: String,
        var ram: Int,
        var almacenamiento: Int,
        var sistemaOperativo: String,
        var programasInstalados: MutableList<Programa>
    ) {
        fun encender() {
            println("La computadora $marca esta encendida")
        }
        fun apagar() {
            println("La computadora $marca esta apagada")
        }
        fun actualizarRam(nuevaRam: Int) {
            ram = nuevaRam
            println("RAM actualizada a $ram GB")
        }
        fun actualizarAlm(nuevoEspacio: Int) {
            almacenamiento = nuevoEspacio
            println("Almacenamiento actualizado a $almacenamiento GB")
        }
        fun actualizarSistema(nuevoSO: String) {
            sistemaOperativo = nuevoSO
            println("Sistema operativo actualizado a $sistemaOperativo")
        }
        fun programasActuales(year: String): List<Programa> {
            return programasInstalados.filter {
                it.nombre.contains(year)
            }
        }
    }
    @Test
    fun main() {
        val programas = mutableListOf(
            Programa("Notion 2026"),
            Programa("Facebook 2024"),
            Programa("VSCode 2026"),
            Programa("Spotify 2023")
        )
        val pc = Computadora(
            marca = "HP",
            ram = 4,
            almacenamiento = 256,
            sistemaOperativo = "Windows 10",
            programasInstalados = programas
        )
        pc.encender()
        pc.actualizarRam( 32)
        pc.actualizarAlm(512)
        pc.actualizarSistema("Windows 11")
        val programas2026 = pc.programasActuales("2026")
        println("Programas del ano 2026:")
        programas2026.forEach {
            println(it.nombre)
        }
        pc.apagar()
    }
}