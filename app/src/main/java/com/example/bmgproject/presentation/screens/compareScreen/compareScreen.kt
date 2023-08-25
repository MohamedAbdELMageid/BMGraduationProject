package com.example.bmgproject.presentation.screens.compareScreen

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bmgproject.R
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
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Back Ground"
        )
    }
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
                        updateState = {
                            compare.updateConvertState()
                            navcontroller.navigate("convert")
                        },
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
                    .height(800.dp)
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

                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
                        CustomTextField(compare.textSt.value,
                            { state -> compare.onValueChange(state) })
                        Spacer(modifier = Modifier.width(20.dp))
                        DropDownList(
                            expanded = compare.expendedSt.value,
                            selectedItem = compare.selectedItem.value,
                            onExpandedChange = { compare.onExpendChange() },
                            onDropDownMenuDismiss = { compare.onDropDownDismiss() },
                            onDropDownItemClick ={selected->compare.onDropDownItemClick(selected)} ,
                            dropDownList = listOf("EGP","USD"),
                            width = 152
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        Text(
                            text = "Targeted Currency",
                            modifier = Modifier,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                        Spacer(modifier = Modifier.width(80.dp))
                        Text(
                            text = "Targeted Currency",
                            modifier = Modifier,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                    }
                    Row {
                        DropDownList(
                            expanded = compare.expendedStS.value,
                            selectedItem = compare.selectedItemS.value,
                            onExpandedChange = { compare.onExpendedChangeS() },
                            onDropDownMenuDismiss = { compare.onDropDownDismissS() },
                            onDropDownItemClick = {selected->compare.onDropDownItemClickS(selected)},
                            dropDownList = listOf("EGP","USD"),
                            width = 152
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        DropDownList(
                            expanded = compare.expendedStT.value,
                            selectedItem = compare.selectedItemT.value,
                            onExpandedChange = { compare.onExpendedChangeT() },
                            onDropDownMenuDismiss = { compare.onDropDownDismissT() },
                            onDropDownItemClick = {selected->compare.onDropDownItemClickT(selected)},
                            dropDownList = listOf("EGP","USD"),
                            width = 152
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        CustomTextField(compare.textSts.value,
                            { state -> compare.onValueChangeS(state) })
                        Spacer(modifier = Modifier.width(60.dp))
                        CustomTextField(compare.textStT.value,
                            { state -> compare.onValueChangeT(state) })
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    MainButton(updateState = { compare.updateState() }, text = "Compare")
                }
            }

        }

}