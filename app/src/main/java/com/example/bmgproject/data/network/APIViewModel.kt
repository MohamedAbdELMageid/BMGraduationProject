package com.example.bmgproject.data.network

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.bmgproject.AppContext
import com.example.bmgproject.data.DBModel.Currency
import com.example.bmgproject.data.Local.CurrencyDatabase
import com.example.bmgproject.data.Repository.Repository
import com.example.bmgproject.data.models.currenciesModel.Currencies
import com.example.bmgproject.data.models.currenciesModel.currenciesList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIViewModel : ViewModel() {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://currencyconversion-production-38ba.up.railway.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val db = Room.databaseBuilder(
        AppContext.appContext,
        CurrencyDatabase::class.java,
        "currency_db"
    ).fallbackToDestructiveMigration().build()


    private val repo = Repository(database = db)
    var customCurrenciessList = mutableStateOf<List<currenciesList>>(emptyList())

    private val network: NetworkServices = retrofit.create(NetworkServices::class.java)


    private var savedCurrency= mutableStateOf<List<Currency>>(emptyList())

    private val mutableResultFlow = MutableStateFlow<String?>(null)
    val resultFlow: StateFlow<String?> = mutableResultFlow

    private val mutableResultFlowF = MutableStateFlow<String?>(null)
    val resultFlowF: StateFlow<String?> = mutableResultFlowF

    private val mutableResultFlowS = MutableStateFlow<String?>(null)
    val resultFlowS: StateFlow<String?> = mutableResultFlowS

    private lateinit var currencies: Currencies

    init {
        getAllCurrenciesFromDB()
        viewModelScope.launch {


            currencies = network.getCurrencies()

            val list = currencies.map {
                Currency(
                    code = it.currency_code,
                )
            }
            repo.insertCurrencies(list)
            publishSavedItems(currencies, list)
        }
    }

    private fun publishSavedItems(
        currencies: Currencies,
        list: List<Currency>,
    ) {
        val transform = currencies.map {
            currenciesList(
                headLine = it.currency_code,
                Icon = it.image_url,
                state = list.firstOrNull { dbItem -> dbItem.code == it.currency_code }?.isSaved
                    ?: false
            )
        }
        customCurrenciessList.value = transform
    }



    fun convertTwoCurrencies(base: String, countryOne: String, amount: String) {
        viewModelScope.launch {
            val result =
                network.convertTwoCurrencies(base, countryOne, amount).conversion_result.toString()
            mutableResultFlow.value = result
        }

    }

    fun convertFirstCurrencies(base: String, countryOne: String, amount: String) {
        viewModelScope.launch {
            val result =
                network.convertTwoCurrencies(base, countryOne, amount).conversion_result.toString()
            mutableResultFlowF.value = result
        }

    }

    fun convertSecondCurrencies(base: String, countryOne: String, amount: String) {
        viewModelScope.launch {
            val result =
                network.convertTwoCurrencies(base, countryOne, amount).conversion_result.toString()
            mutableResultFlowS.value = result
        }

    }

    fun updateItem(item: currenciesList, state: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateCurrency(
                Currency(
                    code = item.headLine,
                    isSaved = state,
                )
            )
            val list = repo.getSavedCurrencies()
            publishSavedItems(currencies, list)
        }
    }

    private fun getAllCurrenciesFromDB(){
        viewModelScope.launch {
            savedCurrency.value=repo.getSavedCurrencies()
        }
    }
}
