package com.example.bmgproject.presentation.screens.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeScreenViewModel:ViewModel() {

    val textSt= mutableStateOf("1")
    fun onValueChange(text:String){
        textSt.value=text
    }

    val expended = mutableStateOf(false)
    val selectedItem= mutableStateOf("--Noy Selected--")
    fun onExpendChange(state:Boolean){
        expended.value=state
    }
    fun onDismissRequest(){
        expended.value=false
    }
    fun onDropDownItemClick(selected:String){
        selectedItem.value=selected
        expended.value=false
    }
}