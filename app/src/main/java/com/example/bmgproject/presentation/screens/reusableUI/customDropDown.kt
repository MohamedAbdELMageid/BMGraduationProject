package com.example.bmgproject.presentation.screens.reusableUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bmgproject.data.models.currenciesModel.currenciesList


@Composable
fun DropDownList(
    expanded: Boolean = false,
    selectedItem: currenciesList? = null,
    onExpandedChange: () -> Unit = {},
    onDropDownMenuDismiss: () -> Unit = {},
    onDropDownItemClick: (currenciesList) -> Unit = {},
    dropDownList: List<currenciesList>,
    width: Int = 184,
    height: Int = 60
) {
    Row(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .clickable {
                onExpandedChange()
            }
            .padding(12.dp)

            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .padding(8.dp)) {
            if (selectedItem != null) {
                Image(
                    painter = rememberAsyncImagePainter(model = selectedItem!!.Icon),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            if (selectedItem != null) {
                Text(text = selectedItem!!.headLine)
            }
            Spacer(modifier = Modifier.width(30.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
        }

        DropdownMenu(
            modifier = Modifier.padding(horizontal = 12.dp),
            expanded = expanded,
            onDismissRequest = { onDropDownMenuDismiss() }) {
            dropDownList.forEach {
                DropdownMenuItem(leadingIcon = {
                    Image(
                        painter = rememberAsyncImagePainter(model = it.Icon),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }, text = { Text(text = it.headLine) }, onClick = {
                    onDropDownItemClick(it)
                })

            }
        }
    }
}
