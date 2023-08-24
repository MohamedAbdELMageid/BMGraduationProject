package com.example.bmgproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmgproject.presentation.screens.compareScreen.CompareViewModel
import com.example.bmgproject.presentation.screens.compareScreen.compareScreen
import com.example.bmgproject.presentation.screens.homeScreen.HomeScreen
import com.example.bmgproject.presentation.screens.homeScreen.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    val home by viewModels<HomeScreenViewModel>()
    val compare by viewModels<CompareViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "home" ){
                composable("home"){
                    HomeScreen(home,navController)
                }
                composable("convert"){
                    HomeScreen(home,navController)
                }
                composable("compare"){
                    compareScreen(compare,navController)
                }
            }
        }
    }
}

