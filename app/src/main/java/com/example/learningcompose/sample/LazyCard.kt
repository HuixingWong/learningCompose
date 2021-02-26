package com.example.learningcompose.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemCardView(index: Int) {

    val visible = remember(calculation = {mutableStateOf(true)})
    AnimatedVisibility(
        visible.value,
        enter = slideIn(
            // Specifies the starting offset of the slide-in to be 1/4 of the width to the right,
            // 100 (pixels) below the content position, which results in a simultaneous slide up
            // and slide left.
            { fullSize -> IntOffset(fullSize.width / 4, 100) },
            tween(300, easing = LinearOutSlowInEasing)
        ),
        initiallyVisible = false
    ) {
        Card(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "I'm a card from Jetpack Compose $index",
                textAlign = TextAlign.Center
            )
        }
    }


}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecyclerViewTest() {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState) {
        for (i in 0..20) {
            item {
                ItemCardView(index = i)
                Spacer(modifier = Modifier.height(8.dp))
            }

        }

    }

}