@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.spacewl.countryprovider

import android.annotation.SuppressLint
import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object CountryProvider {
    private val type = Types.newParameterizedType(List::class.java, SettingCountry::class.java)
    private val moshi = Moshi.Builder().build()

    fun fetchCountries(context: Context): List<Country> {
        val json = LoaderHelper.loadRaw(context, R.raw.country_dial_info)
        return moshi.adapter<List<SettingCountry>>(type)
            .fromJson(json)
            ?.map { country ->
                Country(
                    name = country.name,
                    flagIcon = flagIconByCode(
                        context = context,
                        countryCode = country.code
                    ),
                    code = country.code,
                    dialCode = country.dialCode
                )
            } ?: emptyList()
    }

    fun flagIconByCode(context: Context, countryCode: String): Int {
        return flagIdByName(
            context = context,
            name = "ic_${countryCode.lowercase()}",
        )
    }

    @SuppressLint("DiscouragedApi")
    fun flagIdByName(context: Context, name: String): Int {
        return try {
            val drawableId = context.resources.getIdentifier(name, "drawable", context.packageName)
            if (drawableId == 0) R.drawable.ic_unknown else drawableId
        } catch (exception: Exception) {
            R.drawable.ic_unknown
        }
    }
}