package com.example.bmgproject.presentation.screens.reusableUI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    textSt: String = "1",
    onValueChange: (String) -> Unit = {},
    width: Int = 121,
    height: Int = 44
) {
    OutlinedTextField(
        value = textSt,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clip(AbsoluteRoundedCornerShape(30))
            .background(
                Color.LightGray
            )
            .border(width = 2.dp, color = Color.Black)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownList(
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: (Boolean) -> Unit,
    onDropDownMenuDismiss: () -> Unit,
    onDropDownItemClick: (String) -> Unit,
    dropDownList: List<String>,
    label: String,
){
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {onExpandedChange(it)}) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
            modifier = Modifier.menuAnchor()
                .width(184.dp)
                .height(48.dp),
            label = { Text(text = label)}
            )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {onDropDownMenuDismiss()}) {
            dropDownList.forEach{
                DropdownMenuItem(
                    text = { Text(text = it)},
                    onClick = {onDropDownItemClick(it)})
            }
        }
    }
}





