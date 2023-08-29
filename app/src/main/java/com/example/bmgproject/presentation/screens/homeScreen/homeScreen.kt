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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
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
import coil.compose.rememberAsyncImagePainter
import com.example.bmgproject.R
import com.example.bmgproject.data.models.currenciesModel.currenciesList
import com.example.bmgproject.data.network.APIViewModel
import com.example.bmgproject.presentation.screens.reusableUI.DropDownList
import com.example.bmgproject.presentation.screens.reusableUI.MainButton
import com.example.bmgproject.presentation.screens.reusableUI.SmallButton
import com.example.bmgproject.presentation.screens.reusableUI.customTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    api: APIViewModel,
    updateConvertState: () -> Unit,
    updateCompareState: () -> Unit,
    textSt: String,
    onValueChange: (String) -> Unit,
    expended: Boolean,
    selectedItem: currenciesList?,
    onExpendChange: () -> Unit,
    onDismissRequest: () -> Unit,
    onDropDownItemClick: (currenciesList) -> Unit,
    expendedS: Boolean,
    selectedItemS: currenciesList?,
    onExpendChangeS: () -> Unit,
    onDismissRequestS: () -> Unit,
    onDropDownItemClickS: (currenciesList) -> Unit,
    textSts: String,
    onValueChangeS: (String) -> Unit,
    updateConversionState: () -> Unit,
    onButtonNav: () -> Unit,
    onFavButtonNav: () -> Unit,
    dropDownList: List<currenciesList>
) {


    Box(
        modifier = Modifier
            .height(450.dp)
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
        Spacer(modifier = Modifier.height(80.dp))
        Box(
            modifier = Modifier
                .width(275.dp)
                .height(46.dp)
                .clip(
                    AbsoluteRoundedCornerShape(
                        50
                    )
                )
                .background(Color.White)
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
                    Spacer(modifier = Modifier.width(130.dp))
                    Text(
                        text = "From",
                        modifier = Modifier,
                        color = Color.Black,
                        fontSize = 14.sp,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    customTextField(textSt,
                        { change -> onValueChange(change) })
                    Spacer(modifier = Modifier.width(20.dp))
                    DropDownList(
                        expanded = expended,
                        selectedItem = selectedItem,
                        onExpandedChange = { onExpendChange() },
                        onDropDownMenuDismiss = { onDismissRequest() },
                        onDropDownItemClick = { click -> onDropDownItemClick(click) },
                        dropDownList = dropDownList
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
                    Spacer(modifier = Modifier.width(155.dp))
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
                        dropDownList = dropDownList
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    customTextField(
                        textSts,
                        { change -> onValueChangeS(change) },
                        readonly = true
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                MainButton(
                    updateState = { updateConversionState() },
                    text = "Convert"
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "live exchange rates")
                    Spacer(modifier = Modifier.width(35.dp))
                    Image(imageVector = Icons.Filled.AddCircle, contentDescription = "")
                    SmallButton(
                        updateState = { onFavButtonNav() },
                        text = "Favorites",
                        width = 110
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(api.customCurrenciessList.value) { item ->
                        androidx.compose.material3.ListItem(
                            headlineText = { Text(text = item.headLine) },
                            leadingContent = {
                                Image(
                                    modifier = Modifier.size(30.dp),
                                    painter = rememberAsyncImagePainter(model = item.Icon),
                                    contentDescription = ""
                                )
                            })

                    }
                }
            }
        }

    }
}