package com.spacewl.countryprovider

import android.content.Context
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CountryProviderUnitTest {
    @Mock
    private lateinit var mockContext: Context

    @Test
    fun countries_fetching() {
        val list = runBlocking {
            CountryProvider.fetchCountries(context = mockContext)
        }
        assert(list.isNotEmpty())
    }
}