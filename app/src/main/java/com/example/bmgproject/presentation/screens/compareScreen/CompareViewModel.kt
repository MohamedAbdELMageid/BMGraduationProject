package com.example.bmgproject.presentation.screens.compareScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CompareViewModel : ViewModel() {
    var convert = mutableStateOf(false)
    fun updateConvertState() {
        convert.value = !convert.value
    }

    var compare = mutableStateOf(false)
    fun updateCompareState() {
        compare.value = !compare.value
    }

    val textStT = mutableStateOf("1")
    val textSts = mutableStateOf("1")
    val textSt = mutableStateOf("1")
    fun onValueChange(text: String) {
        textSt.value = text
    }

    fun onValueChangeS(text: String) {
        textSts.value = text
    }

    fun onValueChangeT(text:String){
        textStT.value=text
    }
}