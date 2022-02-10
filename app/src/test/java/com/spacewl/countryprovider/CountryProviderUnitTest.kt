package com.spacewl.countryprovider

import kotlinx.coroutines.runBlocking
import org.junit.Test

class CountryProviderUnitTest {
    @Test
    fun countries_fetching() {
        val list = runBlocking {
            CountryProvider.fetchCountries()
        }
        assert(list.isNotEmpty())
    }
}