package com.example.learningcompose.sample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learningcompose.ext.balance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun EffectTest(scaffoldState: ScaffoldState = rememberScaffoldState(),
               scope: CoroutineScope? = rememberCoroutineScope()) {
//    Test2(scaffoldState, scope)
    Test3()
}

@Composable
fun Test3() {
    var state by remember {
        mutableStateOf(0)
    }
    val scope = rememberCoroutineScope()

    Text(text = state.toString(),
        Modifier
            .clickable {
                scope.launch {
                    while (true) {
                        delay(1000)
                        state++
                    }
                }
            }
            .size(80.dp))
}


@Composable
fun Test2(scaffoldState: ScaffoldState = rememberScaffoldState(), scope: CoroutineScope?) {
    // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
    LaunchedEffect(key1 = true, block = {
        delay(3000)
        scaffoldState.snackbarHostState
            .showSnackbar("😂😂😂")
    })
    Scaffold(scaffoldState = scaffoldState) {
        Column(modifier = Modifier.balance()) {
            /* ... */
            Button(
                onClick = {
                    // Create a new coroutine in the event handler
                    // to show a snackbar
                    scope?.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Something happened!")
                    }
                },
                modifier = Modifier.balance()
            ) {
                Text("Press me")
            }
            Button(
                onClick = {

                },
                modifier = Modifier.balance()
            ) {
                Text("Press two")
            }
        }
    }
}

@Composable
fun Test1(scaffoldState: ScaffoldState = rememberScaffoldState()) {
    // Creates a CoroutineScope bound to the MoviesScreen's lifecycle
    val scope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Column(modifier = Modifier.balance()) {
            /* ... */
            Button(
                onClick = {
                    // Create a new coroutine in the event handler
                    // to show a snackbar
                    scope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Something happened!")
                    }
                },
            ) {
                Text("Press me")
            }
        }
    }
}