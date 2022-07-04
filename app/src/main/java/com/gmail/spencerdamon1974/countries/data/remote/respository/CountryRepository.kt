package com.gmail.spencerdamon1974.countries.data.remote.respository

import com.gmail.spencerdamon1974.countries.data.remote.api.CountryApiClient
import com.gmail.spencerdamon1974.countries.data.remote.model.CountryResponse

class CountryRepository {
    private val apiService = CountryApiClient.retrofitInstance
    suspend fun getCountries(): CountryResponse = apiService.getAllCountries()
}