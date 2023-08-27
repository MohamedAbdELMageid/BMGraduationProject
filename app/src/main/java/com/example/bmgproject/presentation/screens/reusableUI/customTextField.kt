package com.example.bmgproject.presentation.screens.reusableUI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTextField(
    textSt: String = "1",
    onValueChange: (String) -> Unit = {},
    width: Int = 121,
    height: Int = 44
) {
    TextField(
        value = textSt,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            ImeAction.Done
            this.defaultKeyboardAction(ImeAction.Done)
        }),
        modifier = Modifier
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .width(width.dp)
            .height(height.dp)
            .background(
                Color.White
            )
    )
}