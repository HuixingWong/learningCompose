package com.example.learningcompose.ext

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

fun Modifier.normal(index: Int) = Modifier.padding(start = 16.dp, end = 16.dp,
    top = if (index == 0) 16.dp else 0.dp)

fun Modifier.balance() = Modifier.padding(start = 16.dp, end = 16.dp,
    top = 16.dp )

@ExperimentalAnimationApi
val commonEnter = slideIn(
    // Specifies the starting offset of the slide-in to be 1/4 of the width to the right,
    // 100 (pixels) below the content position, which results in a simultaneous slide up
    // and slide left.
    { fullSize -> IntOffset(fullSize.width / 4, 100) },
    tween(300, easing = LinearOutSlowInEasing)
)

@ExperimentalAnimationApi
var commonOut = slideOut(
    // The offset can be entirely independent of the size of the content. This specifies
    // a target offset 180 pixels to the left of the content, and 50 pixels below. This will
    // produce a slide-left combined with a slide-down.
    { IntOffset(-180, 50) },
    tween(1000, easing = FastOutSlowInEasing)
)