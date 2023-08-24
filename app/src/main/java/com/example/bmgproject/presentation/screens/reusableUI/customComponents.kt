package com.example.bmgproject.presentation.screens.reusableUI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    TextField(
        value = textSt,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        modifier = Modifier
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .width(width.dp)
            .height(height.dp)
            //.clip(AbsoluteRoundedCornerShape(30))
            .background(
                Color.White
            )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownList(
    expanded: Boolean,
    selectedItem: String,
    onExpandedChange: () -> Unit,
    onDropDownMenuDismiss: () -> Unit,
    onDropDownItemClick: (String) -> Unit,
    dropDownList: List<String>,
    width: Int = 184,
    height: Int = 48
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { onExpandedChange() }) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor()
                .width(width.dp)
                .height(height.dp),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onDropDownMenuDismiss() }) {
            dropDownList.forEach {
                DropdownMenuItem(
                    text = { Text(text = it) },
                    onClick = { onDropDownItemClick(it) })
            }
        }
    }
}

@Composable
fun MainButton(
    updateState: () -> Unit,
    text: String,
    width: Int = 315,
    height: Int = 48,
) {
    Button(
        colors = ButtonDefaults.buttonColors(Color.Black),
        onClick = { updateState },
        modifier = Modifier
            .height(height.dp)
            .width(width.dp),
    ) {
        Text(text = text)
    }
}

@Composable
fun SmallButton(
    updateState: () -> Unit,
    text: String,
    width: Int = 136,
    height: Int = 46,
) {
    Button(
        colors = ButtonDefaults.buttonColors(Color.White),
        onClick = { updateState() },
        modifier = Modifier
            .height(height.dp)
            .width(width.dp),
    ) {
        Text(text = text, color = Color.Black)
    }
}

