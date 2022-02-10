package com.spacewl.countryprovider

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object CountryProvider {
    private val gson by lazy { GsonBuilder().create() }

    fun fetchCountries(context: Context): List<Country> {
        val json = LoaderHelper.loadRaw(context, R.raw.country_dial_info)
        return gson.fromJson<List<SettingCountry>?>(json, object : TypeToken<List<SettingCountry>>() {}.type)
            .map { country ->
                Country(
                    name = country.name,
                    flagIcon = flagIdByName(
                        name = "ic_${country.code.lowercase()}",
                        context = context
                    ),
                    code = country.code,
                    dialCode = country.dialCode
                )
            }
    }

    private fun flagIdByName(
        name: String,
        context: Context
    ): Int {
        return try {
            val drawableId = context.resources.getIdentifier(name, "drawable", context.packageName)
            if (drawableId == 0) R.drawable.ic_unknown else drawableId
        } catch (exception: Exception) {
            R.drawable.ic_unknown
        }
    }
}