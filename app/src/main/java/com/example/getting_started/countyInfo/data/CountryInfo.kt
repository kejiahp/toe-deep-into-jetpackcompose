package com.example.getting_started.countyInfo.data

data class CountryInfo(
    val flagId: Int,
    val nationalCapital: String,
    val officialName: String,
    val commonName: String,
    val region: String,
    val subRegion: String,
    val currencySymbol: String,
    val currencyName: String,
    val inYen: Float,
    val inUSD: Float
)