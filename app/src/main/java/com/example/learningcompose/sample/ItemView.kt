package com.example.learningcompose.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.learningcompose.ext.commonEnter

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemCardView(index: Int, modifier: Modifier) {

    val visible = remember(calculation = { mutableStateOf(true) })
    AnimatedVisibility(
        visible.value,
        enter = commonEnter,
        initiallyVisible = false
    ) {
        Card(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .then(modifier)
        ) {
            Text(
                text = "I'm a card from Jetpack Compose $index",
                textAlign = TextAlign.Center
            )
        }
    }
}

