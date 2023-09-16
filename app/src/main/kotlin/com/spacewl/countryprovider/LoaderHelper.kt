package com.spacewl.countryprovider

import android.content.Context
import androidx.annotation.RawRes
import java.io.BufferedReader

object LoaderHelper {
    fun loadRaw(
        context: Context,
        @RawRes
        rawResId: Int
    ): String {
        return context.resources
            .openRawResource(rawResId)
            .use { it.bufferedReader(Charsets.UTF_8).use(BufferedReader::readText) }
    }
}