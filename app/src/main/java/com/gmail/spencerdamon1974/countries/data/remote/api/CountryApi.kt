package com.gmail.spencerdamon1974.countries.data.remote.api

import com.gmail.spencerdamon1974.countries.data.remote.model.CountryResponse
import retrofit2.http.GET

interface CountryApi {
    @GET("all")
    suspend fun getCountries(): CountryResponse
}