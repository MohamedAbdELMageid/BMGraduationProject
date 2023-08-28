package com.example.bmgproject.presentation.screens.favoritesScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bmgproject.data.network.APIViewModel
import com.example.bmgproject.presentation.screens.reusableUI.customCheckBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(api: APIViewModel, favorites: FavoritesScreenViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(335.dp)
                .height(551.dp)
                .background(Color.LightGray)
        ) {
            LazyColumn {
                items(api.customCurrenciessList.value) {
                    androidx.compose.material3.ListItem(
                        headlineText = { Text(text = it.headLine) },
                        leadingContent = {
                            Image(
                                modifier = Modifier.size(50.dp),
                                painter = rememberAsyncImagePainter(model = it.Icon),
                                contentDescription = ""
                            )

                        },
                        trailingContent = {
                            customCheckBox(
                                checkSt = favorites.checkSt.value,
                                onChecked = { -> favorites.onChecked() })
                        },
                    )
                }
            }
        }
    }
}

