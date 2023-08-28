package com.example.bmgproject.data.Repository

import android.content.Context
import android.content.SharedPreferences
import com.example.bmgproject.AppContext
import com.example.bmgproject.data.DBModel.Currency
import com.example.bmgproject.data.Local.CurrencyDatabase


class Repository(private val database: CurrencyDatabase) {

    val sharedPreferences: SharedPreferences =
        AppContext.appContext.getSharedPreferences("Currencies", Context.MODE_PRIVATE)

    suspend fun insertCurrency(currency: Currency) = database.currencyDao().insertCurrency(currency)

    suspend fun insertCurrencies(currencies: List<Currency>) {


        database.currencyDao().insertCurrencies(currencies = currencies)
    }

    suspend fun updateCurrency(currency: Currency) = database.currencyDao().updateCurrency(currency)
    suspend fun deleteCurrency(currency: Currency) = database.currencyDao().deleteCurrency(currency)
    suspend fun getSavedCurrencies() = database.currencyDao().getSavedCurrencies()
    suspend fun getCurrenciesByCode(code: String) = database.currencyDao().getCurrenciesByCode(code)

}