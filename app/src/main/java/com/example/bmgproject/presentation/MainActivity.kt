package com.example.bmgproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmgproject.data.network.APIViewModel
import com.example.bmgproject.presentation.screens.compareScreen.CompareViewModel
import com.example.bmgproject.presentation.screens.compareScreen.compareScreen
import com.example.bmgproject.presentation.screens.homeScreen.HomeScreen
import com.example.bmgproject.presentation.screens.homeScreen.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    private val home by viewModels<HomeScreenViewModel>()
    private val compare by viewModels<CompareViewModel>()
    private val api by viewModels<APIViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val newResult = api.resultFlow.collectAsState()
            home.textSts.value=newResult.value ?: "1"
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
                        { home.updateConversionState(home,api) },
                        onButtonNav = { onButtonNav(navController) },
                        api.customCurrenciessList.value
                    )
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
                        { home.updateConversionState(home,api) },
                        onButtonNav = { onButtonNav(navController) },
                        api.customCurrenciessList.value
                    )
                }
                composable("compare") {
                    compareScreen(compare, navController, api)
                }
            }
        }
    }
}

fun onButtonNav(navController: NavController) {
    navController.navigate("compare")
}



