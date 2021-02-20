package com.example.learningcompose.sample

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Home(
        anim: () -> Unit,
        counter: () -> Unit,
) {
    ScrollableColumn(
            modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = anim, modifier = Modifier.padding(16.dp)) {
            Text("Anim")
        }

        Button(onClick = counter, modifier = Modifier.padding(16.dp)) {
            Text("counter")
        }
    }
}