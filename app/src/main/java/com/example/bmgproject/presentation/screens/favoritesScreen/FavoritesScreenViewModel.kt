package com.example.bmgproject.presentation.screens.favoritesScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FavoritesScreenViewModel:ViewModel() {
    var checkSt= mutableStateOf(false)
    fun onChecked(){
        checkSt.value=!checkSt.value
    }
}