package com.gmail.spencerdamon1974.countries.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryApiClient {
    private const val BASE_URL = "https://restcountries.com/v3.1/"
    val retrofitInstance: CountryApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }
}