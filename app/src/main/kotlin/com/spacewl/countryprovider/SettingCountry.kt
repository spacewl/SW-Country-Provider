package com.spacewl.countryprovider

import com.google.gson.annotations.SerializedName

data class SettingCountry(
    val name: String,
    val code: String,
    @SerializedName("dial_code")
    val dialCode: String
)
