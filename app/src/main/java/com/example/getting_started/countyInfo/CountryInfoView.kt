package com.example.getting_started.countyInfo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.getting_started.countyInfo.components.CountryCard
import com.example.getting_started.countyInfo.data.CountryInfo
import com.example.getting_started.ui.theme.Getting_startedTheme
import com.example.getting_started.R
import com.example.getting_started.countyInfo.components.CountryCardWithConstraintLayout

@Composable
private fun CountryInfoView() {
    Text(text = "Country Info View")
}


@Composable
fun CountryInfoMainView() {
    val countryCardInfo: CountryInfo = CountryInfo(
        flagId = R.drawable.madara,
        nationalCapital = "Konouha",
        officialName = "Konohagakure no Sato",
        region = "Land of Fire",
        subRegion = "The Village Hidden in the Leaves",
        currencySymbol = "両",
        currencyName = "Ryo",
        inUSD = 0.01f,
        inYen = 10.0f,
        commonName = "Konouha"
    )
    Getting_startedTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
//            CountryCard(countryCardInfo)
            CountryCardWithConstraintLayout(countryCardInfo)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryInfoMainView()
}