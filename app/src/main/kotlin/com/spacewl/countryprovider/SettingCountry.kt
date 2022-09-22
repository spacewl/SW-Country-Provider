package com.spacewl.countryprovider

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SettingCountry(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "code")
    val code: String,
    @field:Json(name = "dial_code")
    val dialCode: String
)
