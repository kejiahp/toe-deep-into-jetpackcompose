package com.example.getting_started.countyInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.getting_started.countyInfo.data.getCountryList

@Composable
private fun CountryInfoView() {
    Text(text = "Country Info View")
}


@Composable
fun CountryInfoMainView() {
    val countries = getCountryList();

    Getting_startedTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
//            Column(modifier = Modifier.fillMaxSize()) {
//                countries.forEach {
//                    CountryCardWithConstraintLayout(it)
//                }
//            }
            LazyColumn {
                items(countries) {
                    CountryCardWithConstraintLayout(it)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryInfoMainView()
}