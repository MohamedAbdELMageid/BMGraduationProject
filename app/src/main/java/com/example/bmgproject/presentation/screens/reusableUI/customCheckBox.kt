package com.example.bmgproject.presentation.screens.reusableUI

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun customCheckBox(
    checkSt: Boolean = false,
    onChecked: (Boolean) -> Unit = {},
) {
    Checkbox(
        checked = checkSt,
        onCheckedChange = { onChecked(it) },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green,
            uncheckedColor = Color.Gray
        )
    )
}