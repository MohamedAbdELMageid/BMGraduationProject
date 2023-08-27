package com.example.bmgproject.data.network

import com.example.bmgproject.data.models.currenciesModel.Currencies
import com.example.bmgproject.data.models.currenciesModel.CurrenciesExchangeRates
import com.example.bmgproject.data.models.currenciesModel.TwoExchangeRates
import com.example.bmgproject.data.models.currenciesModel.conversionValue
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServices {
    @GET("currency/")
    suspend fun getCurrencies(): Currencies

    @GET("currency/compare?")
    suspend fun getExchangeRates(@Query("base") baseCurrency: String): CurrenciesExchangeRates

    @GET("currency/compareWithTwo?")
    suspend fun getTwoExchangeRates(
        @Query("base") base: String,
        @Query("countryOne") countryOne: String,
        @Query("countryTwo") countryTwo: String
    ): TwoExchangeRates

    @GET("currency/convert?")
    suspend fun convertTwoCurrencies(
        @Query("fromCurrency") base: String,
        @Query("toCurrency") countryOne: String,
        @Query("amount") amount: String
    ): conversionValue

    @GET("currency/convert?")
    suspend fun convertFirstCurrencies(
        @Query("fromCurrency") base: String,
        @Query("toCurrency") countryOne: String,
        @Query("amount") amount: String
    ): conversionValue

    @GET("currency/convert?")
    suspend fun convertSecondCurrencies(
        @Query("fromCurrency") base: String,
        @Query("toCurrency") countryOne: String,
        @Query("amount") amount: String
    ): conversionValue
}