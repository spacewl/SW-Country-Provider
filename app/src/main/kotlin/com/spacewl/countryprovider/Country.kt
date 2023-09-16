package com.spacewl.countryprovider

import androidx.annotation.DrawableRes

data class Country(
    val name: String,
    @DrawableRes
    val flagIcon: Int,
    val code: String,
    val dialCode: String
)