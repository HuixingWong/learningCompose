package com.example.learningcompose.sample

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Home(
        recyclerView: () -> Unit,
        counter: () -> Unit,
        edit: () -> Unit,
) {
    ScrollableColumn(
            modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = recyclerView, modifier = Modifier.padding(16.dp)) {
            Text("recyclerView")
        }

        Button(onClick = counter, modifier = Modifier.padding(16.dp)) {
            Text("counter")
        }

        Button(onClick = edit, modifier = Modifier.padding(16.dp)) {
            Text("stateTest")
        }
    }
}