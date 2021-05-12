package com.example.learningcompose.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun Home(
    recyclerView: () -> Unit,
    counter: () -> Unit,
    edit: () -> Unit,
    anim: () -> Unit,
    coplexList: () -> Unit,
    dragSample: () -> Unit,
    effectTest: () -> Unit
) {

    rememberScrollState(0)
    // use `item` for separate elements like headers
    // and `items` for lists of identical elements

    AnimatedVisibility(
        visible = true , enter = slideInHorizontally(
            // Offsets the content by 1/3 of its width to the left, and slide towards right
            initialOffsetX = { fullWidth -> -fullWidth / 3 },
            // Overwrites the default animation with tween for this slide animation.
            animationSpec = tween(durationMillis = 800)
        ),
        initiallyVisible = false
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
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
            item {
                Button(onClick = coplexList, modifier = Modifier.padding(16.dp)) {
                    Text("coplexList")
                }
            }

            item {
                Button(onClick = dragSample, modifier = Modifier.padding(16.dp)) {
                    Text("dragSample")
                }
            }

            item {
                Button(onClick = effectTest, modifier = Modifier.padding(16.dp)) {
                    Text("effectTest")
                }
            }
        }
    }

}