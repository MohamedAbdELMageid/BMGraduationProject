package com.example.bmgproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.bmgproject.presentation.screens.homeScreen.HomeScreen
import com.example.bmgproject.presentation.screens.homeScreen.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    val home by viewModels<HomeScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(home)
        }
    }
}

