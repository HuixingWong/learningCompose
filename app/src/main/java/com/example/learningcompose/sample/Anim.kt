package com.example.learningcompose.sample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class ListItemAnimationDefinition(delay: Int = 0) {
//    val slideValue = DpPropKey(label = "offset")
//    val definition = transitionDefinition<ListItemAnimationState> {
//        state(ListItemAnimationState.INITIAL) {
//            this[slideValue] = 90.dp
//        }
//        state(ListItemAnimationState.FINAL) {
//            this[slideValue] = 0.dp
//        }
//        transition(
//                fromState = ListItemAnimationState.INITIAL,
//                toState = ListItemAnimationState.FINAL
//        ) {
//            slideValue using tween(
//                    delayMillis = delay,
//                    durationMillis = 300
//            )
//        }
//    }
}

enum class ListItemAnimationState {
    INITIAL,
    FINAL
}


@Composable
fun ItemCardView(index: Int) {
//    val listItemAnimationDefinition = remember(index) {
//        ListItemAnimationDefinition(300)
//    }
//    val listItemTransition = transition(
//            definition = listItemAnimationDefinition.definition,
//            initState = ListItemAnimationState.INITIAL,
//            toState = ListItemAnimationState.FINAL,
//    )
//    Card(
//            modifier = Modifier
//                    .height(200.dp)
//                    .fillMaxWidth()
//                    .absoluteOffset(x = listItemTransition[listItemAnimationDefinition.slideValue])
//    ) {
//        Text(
//                text = "I'm a card from Jetpack Compose $index",
//                textAlign = TextAlign.Center
//        )
//    }
}

@Composable
fun Anim() {
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