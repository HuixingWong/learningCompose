package com.example.learningcompose.sample

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BasicLayout2(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map {
            it.measure(constraints.copy(minHeight = 0))
        }
        layout(
            constraints.maxWidth,
            constraints.maxHeight,
        ) {
            for (i in placeables.indices) {
                val placeable = placeables[i]
                when (i) {
                    0 -> {
                        placeable.place(
                            x = 0,
                            y = 0
                        )
                    }
                    1 -> {
                        placeable.place(
                            x = constraints.maxWidth - placeable.width,
                            y = 0
                        )
                    }
                    2 -> {
                        placeable.place(
                            x = 0,
                            y = constraints.maxHeight - placeable.height
                        )
                    }
                    3 -> {
                        placeable.place(
                            x = constraints.maxWidth - placeable.width,
                            y = constraints.maxHeight - placeable.height
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MyBasicColumn(
    modifier: Modifier = Modifier,
    content: @Composable() () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map {
                it.measure(constraints.copy(minHeight = 0))
            }
            layout(
                constraints.maxWidth,
                constraints.maxHeight,
                alignmentLines = mapOf()
            ) {
                var y = 0
                placeables.forEach {
                    it.place(x = 0, y = y)
                    y += it.height
                }
            }
        }
    )
}

@Preview
@Composable
fun LayoutSample(modifier: Modifier = Modifier) {
    BasicLayout2(modifier) {
        Text("MyBasicColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}

