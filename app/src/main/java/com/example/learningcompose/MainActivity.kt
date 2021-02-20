package com.example.learningcompose

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.Providers
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.learningcompose.sample.Anim
import com.example.learningcompose.sample.Counter
import com.example.learningcompose.sample.Edit
import com.example.learningcompose.sample.Home
import com.example.learningcompose.ui.theme.LearningComposeTheme

val LocalActivity = staticCompositionLocalOf<Activity>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Providers(LocalActivity provides this) {
                LearningComposeTheme {
                    // A surface container using the 'background' color from the theme
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            Crossfade(targetState = "home") {
                                Surface(color = MaterialTheme.colors.background) {
                                    Home(
                                            anim = {
                                                navController.navigate("anim")
                                            },
                                            counter = {
                                                navController.navigate("counter")
                                            },
                                            edit = {
                                                navController.navigate("edit")
                                            }

                                    )
                                }
                            }
                        }

                        composable("anim") {
                            Crossfade(targetState = "anim") {
                                Surface(color = MaterialTheme.colors.background) {
                                    Anim()
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
                    }
                }
            }
        }
    }
}

@Composable
fun Content() {
//    Counter()
    Anim()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningComposeTheme {
    }
}