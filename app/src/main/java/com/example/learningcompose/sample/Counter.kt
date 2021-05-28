package com.example.learningcompose.sample

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningcompose.LocalActivity
import com.example.learningcompose.viewmodel.CounterViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

@Composable
fun Counter() {
    val viewModel: CounterViewModel = viewModel()
    val context = LocalActivity.current
    Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LaunchedEffect(key1 = true) {
            println("😂  launchEffect")
        }

        SideEffect {
            println("😂  sideEffect")
        }

        DisposableEffect(key1 = true) {
            println("😂  disposeEffect")
            onDispose {
                println("😂  disposeEffect dispose")
            }
        }

        /**
         * produceState：将非 Compose 状态转换为 Compose 状态
        produceState 会启动一个协程，该协程将作用域限定为可将值推送到返回的 State 的组合。
        使用此协程将非 Compose 状态转换为 Compose 状态，例如将外部订阅驱动的状态（如 Flow、LiveData 或 RxJava）引入组合。
        该制作工具在 produceState 进入组合时启动，在其退出组合时取消。返回的 State 冲突；设置相同的值不会触发重组。
        即使 produceState 创建了一个协程，它也可用于观察非挂起的数据源。如需移除对该数据源的订阅，请使用 awaitDispose 函数。
        以下示例展示了如何使用 produceState 从网络加载图像。
        loadNetworkImage 可组合函数会返回可以在其他可组合项中使用的 State。
         */
        val pState by produceState(initialValue = 1L) {
            flow {
                while (true) {
                    delay(1000)
                    emit(System.currentTimeMillis())
                }
            }.collect {
               value =  it
            }
        }

        Text(text = pState.toString(), Modifier.background(Color.Green))

        derivedStateOf {

        }

        Text(text = "Hello ${viewModel.amount}!",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(10.dp)
                    .drawBehind {
                        drawRect(Color.Red, size = Size(20f, 20f))
                    }
                    .drawWithContent {
                        drawRect(
                            Color.Black, topLeft = Offset(20f, 20f),
                            size = Size(20f, 20f)
                        )
                        this.drawContent()
                    }
                    .clickable {
                        showMessage(context, "haha")
                    }
        )
        Button(onClick = {
            viewModel.amountPlus()
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "加1")
        }
        Button(onClick = {
            viewModel.amountMinus()
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "减1")
        }
    }
}
fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {

    // This will always refer to the latest onTimeout function that
    // LandingScreen was recomposed with
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    // Create an effect that matches the lifecycle of LandingScreen.
    // If LandingScreen recomposes, the delay shouldn't start again.
    LaunchedEffect(true) {
        delay(1000)
        currentOnTimeout()
    }
    /* Landing screen content */
}
