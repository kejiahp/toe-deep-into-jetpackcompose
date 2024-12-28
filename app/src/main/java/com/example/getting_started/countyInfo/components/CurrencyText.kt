package com.example.getting_started.countyInfo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CurrencyText(currText: String) {
    Text(
        text = currText,
        modifier = Modifier.Companion
            .fillMaxWidth(0.1f)
            .drawBehind {
                drawCircle(
                    color = Color.Companion.LightGray,
                    radius = this.size.maxDimension
                )
            },
        textAlign = TextAlign.Companion.Center
    )
}