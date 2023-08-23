package com.example.bmgproject.presentation.screens.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeScreenViewModel:ViewModel() {

    val textSt= mutableStateOf("1")
    fun onValueChange(text:String){
        textSt.value=text
    }
}