package com.example.getting_started.countyInfo.data

data class CountryInfo(
    val flagId: Int,
    val commonName: String,
    val nationalCapital: String,
    val officialName: String,
    val region: String,
    val subRegion: String,
    val currencySymbol: String,
    val currencyName: String,
    val mobileCode: String,
    val tld: String
)