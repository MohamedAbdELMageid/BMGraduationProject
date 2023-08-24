package com.example.bmgproject.presentation.screens.compareScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CompareViewModel:ViewModel() {
    var convert = mutableStateOf(false)
    fun updateConvertState() {
        convert.value = !convert.value
    }

    var compare = mutableStateOf(false)
    fun updateCompareState() {
        compare.value = !compare.value
    }
}