package com.example.getting_started.countyInfo.components

import androidx.compose.foundation.Image
import com.example.getting_started.countyInfo.data.CountryInfo
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.getting_started.R

@Composable
fun CountryCard(cardInfo: CountryInfo) {
    /**
     * Padding is applied in order of declaration.
     *
     * First padding of 10 density independent pixels
     *
     * Then the surface height & border
     *
     * Lastly a padding of 5 density independent pixels
     */
    Surface(
        modifier = Modifier.Companion
            .fillMaxWidth(1.0f)
            .padding(10.dp)
            .wrapContentHeight(align = Alignment.Companion.Top)
            .border(
                1.dp,
                Color.Companion.LightGray
            ),
        shadowElevation = 2.dp,
    ) {
        Row(modifier = Modifier.Companion.fillMaxWidth()) {
            Column(
                modifier = Modifier.Companion
                    .fillMaxWidth(0.2f)
                    .weight(0.2f)
            ) {
                Box(
                    modifier = Modifier.Companion
                        .width(80.dp)
                        .height(80.dp)
                        .padding(2.dp),
                    contentAlignment = Alignment.Companion.Center
                ) {
                    val imageResourceId = cardInfo.flagId
                    val imagePainter: Painter = painterResource(id = imageResourceId)
                    Image(
                        painter = imagePainter,
                        contentDescription = cardInfo.officialName,
                        contentScale = ContentScale.Companion.Fit,
                        modifier = Modifier.Companion.fillMaxWidth()
                    )
                }

                Text(
                    text = cardInfo.nationalCapital,
                    modifier = Modifier.Companion.fillMaxWidth(),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Companion.Center
                )

                Text(
                    text = cardInfo.officialName,
                    modifier = Modifier.Companion.fillMaxWidth(),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Companion.Center
                )
            }
            Column(
                modifier = Modifier.Companion
                    .fillMaxWidth(0.8f)
                    .weight(0.8f),
            ) {
                Text(
                    text = cardInfo.officialName,
                    modifier = Modifier.Companion.fillMaxWidth(),
                    textAlign = TextAlign.Companion.Center,
                    fontSize = 20.sp
                )
                Text(
                    text = cardInfo.subRegion,
                    modifier = Modifier.Companion.fillMaxWidth(),
                    textAlign = TextAlign.Companion.Center,
                    fontSize = 16.sp
                )
                Text(
                    text = cardInfo.region,
                    modifier = Modifier.Companion.fillMaxWidth(),
                    textAlign = TextAlign.Companion.Center,
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.Companion.fillMaxWidth(1.0f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Companion.CenterVertically
                ) {
                    CurrencyText(currText = cardInfo.currencySymbol, modifier = null)
                    Text(
                        text = cardInfo.currencyName,
                        modifier = Modifier.Companion.fillMaxWidth(0.3f),
                        textAlign = TextAlign.Companion.Center
                    )
                    Column(modifier = Modifier.Companion.fillMaxWidth(0.4f)) {
                        Text(text = "${cardInfo.inYen} YEN", textAlign = TextAlign.Companion.Center)
                        Text(text = "${cardInfo.inUSD} USD", textAlign = TextAlign.Companion.Center)
                    }
                }
            }
        }
    }
}