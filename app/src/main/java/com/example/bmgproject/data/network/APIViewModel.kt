package com.example.bmgproject.data.network

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmgproject.data.models.currenciesModel.currenciesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIViewModel() : ViewModel() {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://currencyconversion-production-38ba.up.railway.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var customCurrenciessList = mutableStateOf<List<currenciesList>>(emptyList())

    private val network: NetworkServices = retrofit.create(NetworkServices::class.java)


    private val mutableResultFlow = MutableStateFlow<String?>(null)
    val resultFlow: StateFlow<String?> = mutableResultFlow

    private val mutableResultFlowF = MutableStateFlow<String?>(null)
    val resultFlowF: StateFlow<String?> = mutableResultFlowF

    private val mutableResultFlowS = MutableStateFlow<String?>(null)
    val resultFlowS: StateFlow<String?> = mutableResultFlowS

    init {
        viewModelScope.launch {
            var currencies = network.getCurrencies()
            var transform = currencies.map {
                currenciesList(
                    headLine = it.currency_code,
                    Icon = it.image_url
                )
            }
            customCurrenciessList.value = transform
        }
    }

    fun getExchangeRates(base: String) {
        viewModelScope.launch {
            network.getExchangeRates(base)
        }
    }

    fun getTwoExchangeRates(base: String, countryOne: String, countryTwo: String) {
        viewModelScope.launch {
            network.getTwoExchangeRates(base, countryOne, countryTwo)
        }
    }

    fun convertTwoCurrencies(base: String, countryOne: String, amount: String) {
        viewModelScope.launch {
            val result =
                network.convertTwoCurrencies(base, countryOne, amount).conversion_value.toString()
            mutableResultFlow.value = result
        }

    }

    fun convertFirstCurrencies(base: String, countryOne: String, amount: String) {
        viewModelScope.launch {
            val result =
                network.convertTwoCurrencies(base, countryOne, amount).conversion_value.toString()
            mutableResultFlowF.value = result
        }

    }

    fun convertSecondCurrencies(base: String, countryOne: String, amount: String) {
        viewModelScope.launch {
            val result =
                network.convertTwoCurrencies(base, countryOne, amount).conversion_value.toString()
            mutableResultFlowS.value = result
        }

    }
}