package com.example.bmgproject.presentation.screens.compareScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bmgproject.presentation.screens.reusableUI.CustomTextField
import com.example.bmgproject.presentation.screens.reusableUI.DropDownList
import com.example.bmgproject.presentation.screens.reusableUI.MainButton
import com.example.bmgproject.presentation.screens.reusableUI.SmallButton

@Composable
fun compareScreen(
    compare: CompareViewModel,
    navcontroller: NavController
) {
    Box(
        modifier = Modifier
            .height(405.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF6A0E1C), Color(0xFF2A0F14))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(318.dp)
                    .height(63.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Currency Conversion",
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Check live foreign currency exchange rates",
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Box(
                modifier = Modifier
                    .width(275.dp)
                    .height(46.dp)
                    .clip(
                        AbsoluteRoundedCornerShape(
                            50
                        )
                    )
                    .background(Color.LightGray)
            ) {
                Row {
                    SmallButton(
                        updateState = { compare.updateConvertState()
                            navcontroller.navigate("convert")},
                        text = "Convert",
                        width = 136,
                        height = 46
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    SmallButton(
                        updateState = {
                            compare.updateCompareState()
                        },
                        text = "Compare",
                        width = 136,
                        height = 46
                    )
                }
            }
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(409.dp)
                    .background(Color.White),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding((10.dp)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(modifier = Modifier) {

                        Text(
                            text = "Amount",
                            modifier = Modifier,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                        Spacer(modifier = Modifier.width(120.dp))
                        Text(
                            text = "From",
                            modifier = Modifier,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row {

                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        Text(
                            text = "To",
                            modifier = Modifier,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                        Spacer(modifier = Modifier.width(120.dp))
                        Text(
                            text = "Amount",
                            modifier = Modifier,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                    }
                }
            }

        }
    }
}