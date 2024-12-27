package com.example.getting_started.countyInfo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.getting_started.ui.theme.Getting_startedTheme

@Composable
private fun CountryInfoView() {
    Text(text="Country Info View")
}

@Composable
fun CountryCard() {
    /**
     * Padding is applied in order of declaration.
     *
     * First padding of 10 density independent pixels
     *
     * Then the surface height & border
     *
     * Lastly a padding of 5 density independent pixels
     */
    Surface(modifier = Modifier.padding(10.dp).fillMaxWidth(1.0f).wrapContentHeight(align = Alignment.Top).border(1.dp,
        Color.LightGray).padding(5.dp)) {
        Text(text="Country Info View")
    }
}

@Composable
fun CountryInfoMainView() {
    Getting_startedTheme {
        Surface (modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.surface) {
            CountryCard()
        }

    }
}