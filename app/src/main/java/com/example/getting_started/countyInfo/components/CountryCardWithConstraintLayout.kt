package com.example.getting_started.countyInfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.getting_started.countyInfo.data.CountryInfo

/**
 * The only benefit of using the ConstraintLayout composable over nesting composables is code readability and it allows use to position composable relative to other composables
 *
 * [Official Jetpack documentation on ConstraintLayout](https://developer.android.com/develop/ui/compose/layouts/constraintlayout)
 */
@Composable
fun CountryCardWithConstraintLayout(cardInfo: CountryInfo) {
    ConstraintLayout(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(2.dp)
            .shadow(
                1.dp,
                RectangleShape
            )
    ) {
        val (flag, commonName, capital, officialName, region, subregion, currencySymbol, currencyName, mobileCode, tld) = createRefs()

        val imageResourceId = cardInfo.flagId
        val imagePainter: Painter = painterResource(id = imageResourceId)

        Image(painter = imagePainter,
            contentDescription = "Country Flag",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(0.35f)
                .height(70.dp)
                .padding(2.dp)
                .constrainAs(flag) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })


        Text(
            text = cardInfo.commonName,
            modifier = Modifier
                .padding(2.dp)
                .constrainAs(commonName) {
                    top.linkTo(flag.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(flag.end)
                },
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Text(text = cardInfo.nationalCapital,
            fontSize = 15.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(2.dp)
                .constrainAs(capital) {
                    start.linkTo(parent.start)
                    top.linkTo(commonName.bottom)
                    end.linkTo(flag.end)
                })

        Text(text = cardInfo.officialName,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(officialName) {
                    top.linkTo(parent.top)
                    start.linkTo(flag.end)
                    end.linkTo(parent.end)
                }
                .padding(2.dp)
                .fillMaxWidth(0.65f))

        Text(text = cardInfo.region,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(region) {
                    start.linkTo(flag.end)
                    end.linkTo(parent.end)
                    top.linkTo(officialName.bottom)
                }
                .padding(2.dp)
                .fillMaxWidth(0.8f))

        Text(text = cardInfo.subRegion,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(subregion) {
                    start.linkTo(officialName.start)
                    top.linkTo(region.bottom)
                    end.linkTo(officialName.end)
                }
                .padding(2.dp)
                .fillMaxWidth(0.8f))

        CurrencyText(currText = cardInfo.currencySymbol,
            modifier = Modifier
                .drawBehind {
                    drawCircle(color = Color.LightGray, radius = 40.0f)
                }
                .constrainAs(currencySymbol) {
                    start.linkTo(flag.end, margin = 30.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                })
        Text(
            text = cardInfo.currencyName,
            modifier = Modifier
                .constrainAs(currencyName) {
                    top.linkTo(subregion.bottom)
                    start.linkTo(currencySymbol.end, margin = 12.dp)
                    bottom.linkTo(parent.bottom, margin = 5.dp)
                    end.linkTo(mobileCode.start)
                }, textAlign = TextAlign.Center
        )

        Text(
            text = "${cardInfo.inYen} YEN",
            modifier = Modifier
                .constrainAs(mobileCode) {
                    top.linkTo(subregion.bottom)
                    end.linkTo(parent.end)
                }
                .width(100.dp)
        )

        Text(
            text = "${cardInfo.inUSD} USD",
            modifier = Modifier
                .constrainAs(tld) {
                    top.linkTo(mobileCode.bottom)
                    end.linkTo(parent.end)
                }
                .width(100.dp)
        )

    }
}