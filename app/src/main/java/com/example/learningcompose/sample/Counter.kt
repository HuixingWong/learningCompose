package com.example.learningcompose.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Counter(amount: MutableState<Int>){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Hello ${amount.value}!", modifier = Modifier.padding(10.dp))
        Button(onClick = {
            amount.value++
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "加1")
        }
        Button(onClick = {
            amount.value--
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "减1")
        }
    }
}