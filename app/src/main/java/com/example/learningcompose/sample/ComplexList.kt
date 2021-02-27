package com.example.learningcompose.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learningcompose.ext.balance
import com.example.learningcompose.ext.commonEnter
import com.example.learningcompose.ext.commonOut
import com.example.learningcompose.ext.normal

@ExperimentalAnimationApi
@Composable
fun ComPlexList() {

    AnimatedVisibility(visible = true, enter = commonEnter, exit = commonOut) {
        LazyColumn {
            item {
                LazyRow {
                    for (i in 0..20) {
                        item {
                            ItemCardView(index = i, Modifier.balance())
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }

            item {
                LazyRow {
                    for (i in 0..20) {
                        item {
                            ItemCardView(index = i, Modifier.balance())
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }

            for (i in 0..20) {
                item {
                    ItemCardView(index = i, modifier = Modifier.normal(i))
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

    }

}

