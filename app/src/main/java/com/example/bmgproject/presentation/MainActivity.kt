package com.example.bmgproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavController
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
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(
                        { home.updateConvertState() },
                        { home.updateCompareState() },
                        home.textSt.value,
                        { change -> home.onValueChange(change) },
                        home.expended.value,
                        home.selectedItem.value,
                        { home.onExpendChange() },
                        { home.onDismissRequest() },
                        { click -> home.onDropDownItemClick(click) },
                        home.expendedS.value,
                        home.selectedItemS.value,
                        { home.onExpendChangeS() },
                        { home.onDismissRequestS() },
                        { click -> home.onDropDownItemClickS(click) },
                        home.textSts.value,
                        { change -> home.onValueChangeS(change) },
                        { home.updateConversionState() },
                        onButtonNav = { onButtonNav(navController)})
                }
                composable("convert") {
                    HomeScreen(
                        { home.updateConvertState() },
                        { home.updateCompareState() },
                        home.textSt.value,
                        { change -> home.onValueChange(change) },
                        home.expended.value,
                        home.selectedItem.value,
                        { home.onExpendChange() },
                        { home.onDismissRequest() },
                        { click -> home.onDropDownItemClick(click) },
                        home.expendedS.value,
                        home.selectedItemS.value,
                        { home.onExpendChangeS() },
                        { home.onDismissRequestS() },
                        { click -> home.onDropDownItemClickS(click) },
                        home.textSts.value,
                        { change -> home.onValueChangeS(change) },
                        { home.updateConversionState() },
                        onButtonNav = { onButtonNav(navController)})
                }
                composable("compare") {
                    compareScreen(compare, navController)
                }
            }
        }
    }
}

fun onButtonNav(navController: NavController){
    navController.navigate("compare")
}