package com.example.learningcompose.sample

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningcompose.LocalActivity
import com.example.learningcompose.viewmodel.CounterViewModel
import kotlinx.coroutines.delay

@Composable
fun Counter() {
    val viewModel: CounterViewModel = viewModel()
    val context = LocalActivity.current
    Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LaunchedEffect(key1 = true) {
            println("😂  launchEffect")
        }

        SideEffect {
            println("😂  sideEffect")
        }

        DisposableEffect(key1 = true) {
            println("😂  disposeEffect")
            onDispose {
                println("😂  disposeEffect dispose")
            }
        }

        produceState(initialValue = 1) {
            awaitDispose {

            }
        }

        derivedStateOf {

        }

        Text(text = "Hello ${viewModel.amount}!",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(10.dp)
                    .drawBehind {
                        drawRect(Color.Red, size = Size(20f, 20f))
                    }
                    .drawWithContent {
                        drawRect(
                            Color.Black, topLeft = Offset(20f, 20f),
                            size = Size(20f, 20f)
                        )
                        this.drawContent()
                    }
                    .clickable {
                        showMessage(context, "haha")
                    }
        )
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
fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {

    // This will always refer to the latest onTimeout function that
    // LandingScreen was recomposed with
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    // Create an effect that matches the lifecycle of LandingScreen.
    // If LandingScreen recomposes, the delay shouldn't start again.
    LaunchedEffect(true) {
        delay(1000)
        currentOnTimeout()
    }
    /* Landing screen content */
}
