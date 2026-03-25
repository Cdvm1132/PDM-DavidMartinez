package com.example.laboratorio2

import androidx.compose.runtime.mutableStateListOf
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio2.ui.theme.Laboratorio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}

@Composable
fun Greeting(name: String, ) {
Column() {    Text(
    text = "Hello $name!",
    modifier = Modifier
)
    Text("xd",
            modifier = Modifier

    )

} }



@Composable
fun GreetingPreview() {
    Laboratorio2Theme {
        Greeting("Android")
    }
}
@Preview(showBackground = true)
@Composable
fun app() {

    var usuario by remember { mutableStateOf("") }

    val userlist = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        TextField(
            label = { Text("Nombre") },
            value = usuario,
            onValueChange = {
                usuario = it
            }
        )

        Button(
            onClick = {
                if (usuario.isNotBlank()) {
                    userlist.add(usuario)
                    usuario = "" // limpia el campo
                }
            }
        ) {
            Text("Guardar")
        }

        Row {
            Text("Listado de nombres")

            Button(
                onClick = {
                    userlist.clear()
                }
            ) {
                Text("Limpiar")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .border(2.dp, Color.Blue)
        ) {
            LazyColumn {
                items(userlist.size) { index ->
                    Text(
                        text = "${index + 1}. ${userlist[index]}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}