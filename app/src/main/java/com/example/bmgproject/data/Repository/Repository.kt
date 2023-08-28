package com.example.bmgproject.data.Repository

import com.example.bmgproject.data.DBModel.Currency
import com.example.bmgproject.data.Local.CurrencyDatabase


class Repository(private val database: CurrencyDatabase = CurrencyDatabase.invoke()) {


    suspend fun insertCurrency(currency: Currency) = database.currencyDao().insertCurrency(currency)
    suspend fun deleteCurrency(currency: Currency) = database.currencyDao().deleteCurrency(currency)
    suspend fun getSavedCurrencies() = database.currencyDao().getSavedCurrencies()
    suspend fun getCurrenciesByCode(code: String) = database.currencyDao().getCurrenciesByCode(code)

}
