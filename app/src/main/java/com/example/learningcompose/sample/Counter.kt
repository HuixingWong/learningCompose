package com.example.learningcompose.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.learningcompose.viewmodel.CounterViewModel

@Composable
fun Counter(){
    val viewModel:CounterViewModel = viewModel()
    val state = viewModel.amount.observeAsState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Hello ${state.value}!", modifier = Modifier.padding(10.dp))
        Button(onClick = {
            viewModel.amountPlus()
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "加1")
        }
        Button(onClick = {
            viewModel.amountMinus()
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "减1")
        }
    }
}