package com.example.learningcompose.sample


import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun DragSample() {

    // Draw a seekbar-like composable that has a black background
    // with a red square that moves along the 300.dp drag distance
    val max = 300.dp
    val min = 0.dp
    val (minPx, maxPx) = with(LocalDensity.current) { min.toPx() to max.toPx() }
    // this is the  state we will update while dragging
    val offsetPosition = remember {
        mutableStateOf(0f)
    }

    // seekbar itself
    Box(
        modifier = Modifier
            .width(max)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    val newValue = offsetPosition.value + delta
                    offsetPosition.value = newValue.coerceIn(minPx, maxPx)
                }
            )
            .background(Color.Black)
    ) {
        Box(
            Modifier.offset { IntOffset(offsetPosition.value.roundToInt(), 0) }
                .size(50.dp)
                .background(Color.Red)
        )
    }

}