package com.example.learningcompose.viewmodel

import android.os.Bundle
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

fun <T> SavedStateHandle.getMutableStateOf(
        key: String,
        default: T,
        save: (T) -> Bundle,
        restore: (Bundle) -> T
): MutableState<T> {
    val bundle: Bundle? = get(key)
    val initial = if (bundle == null) {
        default
    } else {
        restore(bundle)
    }
    val state = mutableStateOf(initial)
    setSavedStateProvider(key) {
        save(state.value)
    }
    return state
}


class CounterViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    //    private val _amount = MutableLiveData(0)
    var amount: Int by savedStateHandle.getMutableStateOf<Int>("amount", 0,
            save = {
                Bundle().apply {
                    putInt("amount", it)
                }
            },
            restore = { bundle -> bundle.getInt("amount") }
    )
        private set

    fun amountPlus() {
        amount += 1
    }

    fun amountMinus() {
        amount -= 1
    }

}