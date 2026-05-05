package com.example.laboratorio2.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun app(navController: NavController) {

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
                    usuario = ""
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
                .size(500.dp)
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
        Box(){
            Row(){
                Button(onClick = {},modifier = Modifier

                ) {
                    Text("Atras",color=Color.Black)
                }


            }
        }

    }
}