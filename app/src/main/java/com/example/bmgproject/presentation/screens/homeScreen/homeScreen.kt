package com.example.bmgproject.presentation.screens.homeScreen

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmgproject.R
import com.example.bmgproject.presentation.screens.reusableUI.CustomTextField
import com.example.bmgproject.presentation.screens.reusableUI.DropDownList
import com.example.bmgproject.presentation.screens.reusableUI.MainButton
import com.example.bmgproject.presentation.screens.reusableUI.SmallButton

@Composable
fun HomeScreen(
    updateConvertState: () -> Unit,
    updateCompareState: () -> Unit,
    textSt: String,
    onValueChange: (String) -> Unit,
    expended: Boolean,
    selectedItem: String,
    onExpendChange: () -> Unit,
    onDismissRequest: () -> Unit,
    onDropDownItemClick: (String) -> Unit,
    expendedS: Boolean,
    selectedItemS: String,
    onExpendChangeS: () -> Unit,
    onDismissRequestS: () -> Unit,
    onDropDownItemClickS: (String) -> Unit,
    textSts: String,
    onValueChangeS: (String) -> Unit,
    updateConversionState: () -> Unit,
    onButtonNav: () -> Unit
) {

    Box(
        modifier = Modifier
            .height(405.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Back Ground"
        )
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
                        updateState = { updateConvertState() },
                        text = "Convert",
                        width = 136,
                        height = 46
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    SmallButton(
                        updateState = {
                            updateCompareState()
                            onButtonNav()
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
                        CustomTextField(textSt,
                            { change -> onValueChange(change) })
                        Spacer(modifier = Modifier.width(20.dp))
                        DropDownList(
                            expanded = expended,
                            selectedItem = selectedItem,
                            onExpandedChange = { onExpendChange() },
                            onDropDownMenuDismiss = { onDismissRequest() },
                            onDropDownItemClick = { click -> onDropDownItemClick(click) },
                            dropDownList = listOf("EGP", "USD")
                        )
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

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        DropDownList(
                            expanded = expendedS,
                            selectedItem = selectedItemS,
                            onExpandedChange = { onExpendChangeS() },
                            onDropDownMenuDismiss = { onDismissRequestS() },
                            onDropDownItemClick = { click ->
                                onDropDownItemClickS(
                                    click
                                )
                            },
                            dropDownList = listOf("EGP", "USD"),
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        CustomTextField(textSts,
                            { change -> onValueChangeS(change) })
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    MainButton(
                        updateState = { updateConversionState() },
                        text = "Convert"
                    )

                }
            }

        }

    }
}
