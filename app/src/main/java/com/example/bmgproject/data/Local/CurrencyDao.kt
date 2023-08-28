package com.example.bmgproject.data.Local

import androidx.room.Insert
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bmgproject.data.DBModel.Currency


@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: Currency)
    @Delete
    suspend fun deleteCurrency(currency: Currency)

    @Query("select * from currency")
    suspend fun getSavedCurrencies(): List<Currency>

    @Query("select * from currency where code = :code")
    suspend fun getCurrenciesByCode(code: String):Currency
}
