package com.example.learningcompose.main

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.learningcompose.sample.*

@ExperimentalAnimationApi
fun NavGraphBuilder.myNavigation(navController: NavController) {
    composable("home") {
        Crossfade(targetState = "home") {
            Surface(color = MaterialTheme.colors.background) {
                Home(
                    recyclerView = {
                        navController.navigate("recyclerView")
                    },
                    counter = {
                        navController.navigate("counter")
                    },
                    edit = {
                        navController.navigate("edit")
                    },
                    anim = {
                        navController.navigate("anim")
                    },
                    coplexList = {
                        navController.navigate("coplexList")
                    } ,
                    dragSample = {
                        navController.navigate("dragSample")
                    }
                )
            }
        }
    }

    composable("recyclerView") {
        Crossfade(targetState = "recyclerView") {
            Surface(color = MaterialTheme.colors.background) {
                RecyclerViewTest()
            }
        }
    }

    composable("counter") {
        Crossfade(targetState = "counter") {
            Surface(color = MaterialTheme.colors.background) {
                Counter()
            }
        }
    }

    composable("edit") {
        Crossfade(targetState = "edit") {
            Surface(color = MaterialTheme.colors.background) {
                Edit()
            }
        }
    }

    composable("anim") {
        Crossfade(targetState = "anim") {
            Surface(color = MaterialTheme.colors.background) {
                SlideInOutSample()
            }
        }
    }

    composable("coplexList") {
        Crossfade(targetState = "coplexList") {
            Surface(color = MaterialTheme.colors.background) {
                ComPlexList()
            }
        }
    }
    composable("dragSample") {
        Crossfade(targetState = "dragSample") {
            Surface(color = MaterialTheme.colors.background) {
                DragSample()
            }
        }
    }
}