package com.example.bmgproject.presentation.screens.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController

class HomeScreenViewModel : ViewModel() {

    val textSts = mutableStateOf("1")
    val textSt = mutableStateOf("1")
    fun onValueChange(text: String) {
        textSt.value = text
    }

    fun onValueChangeS(text: String) {
        textSts.value = text
    }

    val expended = mutableStateOf(false)
    val selectedItem = mutableStateOf("--Not Selected--")
    fun onExpendChange() {
        expended.value = !expended.value
    }

    fun onDismissRequest() {
        expended.value = false
    }

    fun onDropDownItemClick(selected: String) {
        selectedItem.value = selected
        expended.value = false
    }

    val expendedS = mutableStateOf(false)
    val selectedItemS = mutableStateOf("--Not Selected--")
    fun onExpendChangeS() {
        expendedS.value = !expendedS.value
    }

    fun onDismissRequestS() {
        expendedS.value = false
    }

    fun onDropDownItemClickS(selected: String) {
        selectedItemS.value = selected
        expendedS.value = false
    }

    var conversionSt = mutableStateOf(false)
    fun updateConversionState(): Boolean {
        conversionSt.value = !conversionSt.value
        return conversionSt.value
    }

    var convert = mutableStateOf(false)
    fun updateConvertState() {
        convert.value = !convert.value
    }

    var compare = mutableStateOf(false)
    fun updateCompareState() {
        compare.value = !compare.value
    }
}