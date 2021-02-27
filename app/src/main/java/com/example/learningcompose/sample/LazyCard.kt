package com.example.learningcompose.sample

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learningcompose.ext.normal


@SuppressLint("RememberReturnType")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecyclerViewTest() {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState) {
        for (i in 0..20) {
            item {
                ItemCardView(index = i, Modifier.normal(i))
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }

}