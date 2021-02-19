package com.example.learningcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _amount = MutableLiveData(0)
    val amount: LiveData<Int> = _amount

    fun amountPlus() {
        _amount.apply {
            value = value?.plus(1)
        }
    }

    fun amountMinus() {
        _amount.apply {
            value = value?.minus(1)
        }
    }

}