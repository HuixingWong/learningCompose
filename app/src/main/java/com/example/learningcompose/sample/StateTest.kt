package com.example.learningcompose.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloViewModel : ViewModel() {

    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    // onNameChanged is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onNameChanged(newName: String) {
        _name.value = newName
    }
}

/**
 *  事件：系统调用 onNameChanged 来响应用户输入字符的操作。
    更新状态：onNameChanged 会进行处理，然后设置 _name 的状态。
    显示状态：name 的值发生变化，这由 Compose 在 observeAsState 中观察。然后，HelloScreen 再次运行（或重组），以根据 name 的新值描述界面。
 */
@Composable
fun Edit(helloViewModel: HelloViewModel = viewModel()) {
    val name = helloViewModel.name.observeAsState()
    Column {
        Text(text = name.value!!)
        TextField(value = name.value!!, onValueChange = {
            helloViewModel.onNameChanged(it)
        }, label = {
            Text(text = "name")
        })
    }
}