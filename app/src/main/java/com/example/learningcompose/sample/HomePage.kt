package com.example.learningcompose.sample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
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
    anim: () -> Unit,
) {

    rememberScrollState(0f)
    // use `item` for separate elements like headers
    // and `items` for lists of identical elements
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // use `item` for separate elements like headers
        // and `items` for lists of identical elements
        item {
            Button(onClick = recyclerView, modifier = Modifier.padding(16.dp)) {
                Text("recyclerView")
            }
        }
        item {
            Button(onClick = counter, modifier = Modifier.padding(16.dp)) {
                Text("counter")
            }
        }
        item {
            Button(onClick = edit, modifier = Modifier.padding(16.dp)) {
                Text("stateTest")
            }
        }
        item {
            Button(onClick = anim, modifier = Modifier.padding(16.dp)) {
                Text("AnimTest")
            }
        }

    }
}