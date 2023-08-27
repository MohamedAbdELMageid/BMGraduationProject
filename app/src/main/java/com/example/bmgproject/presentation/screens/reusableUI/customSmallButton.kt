package com.example.bmgproject.presentation.screens.reusableUI

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
