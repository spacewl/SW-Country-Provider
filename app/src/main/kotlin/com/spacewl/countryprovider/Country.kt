package com.spacewl.countryprovider

import androidx.annotation.DrawableRes
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    val name: String,
    @DrawableRes
    val flagIcon: Int,
    val code: String,
    val dialCode: String
)