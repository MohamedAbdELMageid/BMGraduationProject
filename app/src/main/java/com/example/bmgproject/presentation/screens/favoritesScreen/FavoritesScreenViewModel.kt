package com.example.bmgproject.presentation.screens.favoritesScreen

import androidx.lifecycle.ViewModel

class FavoritesScreenViewModel : ViewModel() {
    fun onChecked(state: Boolean) {
        if (state){
            // save
        }else {
            // remove
        }
    }
}