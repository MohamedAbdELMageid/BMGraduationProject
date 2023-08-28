package com.example.bmgproject.data.Local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bmgproject.data.DBModel.Currency


@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: Currency)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(currencies: List<Currency>)

    @Delete
    suspend fun deleteCurrency(currency: Currency)

    @Query("select * from currency")
    suspend fun getSavedCurrencies(): List<Currency>

    @Query("select * from currency where code = :code")
    suspend fun getCurrenciesByCode(code: String): Currency

    @Update
    suspend fun updateCurrency(currency: Currency)
}
