package com.example.learningcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.learningcompose.sample.Anim
import com.example.learningcompose.sample.Counter
import com.example.learningcompose.sample.Home
import com.example.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Surface(color = MaterialTheme.colors.background) {
                            Home(
                                    anim = {
                                        navController.navigate("anim")
                                    },
                                    counter = {
                                        navController.navigate("counter")
                                    }
                            )
                        }
                    }
                    composable("anim") {
                        Surface(color = MaterialTheme.colors.background) {
                            Anim()
                        }
                    }
                    composable("counter") {
                        Surface(color = MaterialTheme.colors.background) {
                            Counter()
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