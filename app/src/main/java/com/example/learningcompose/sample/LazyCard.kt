package com.example.learningcompose.sample

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemCardView(index: Int) {

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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecyclerViewTest() {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState) {
        for (i in 0..20) {
            item {
                ItemCardView(index = i)
                Spacer(modifier = Modifier.preferredHeight(8.dp))
            }

        }

    }

}