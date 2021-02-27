package com.example.learningcompose

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.learningcompose.main.myNavigation
import com.example.learningcompose.sample.RecyclerViewTest
import com.example.learningcompose.ui.theme.LearningComposeTheme

val LocalActivity = staticCompositionLocalOf<Activity> { error("no activity") }

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalActivity provides this) {
                LearningComposeTheme {
                    // A surface container using the 'background' color from the theme
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                       myNavigation(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Content() {
//    Counter()
    RecyclerViewTest()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningComposeTheme {
    }
}