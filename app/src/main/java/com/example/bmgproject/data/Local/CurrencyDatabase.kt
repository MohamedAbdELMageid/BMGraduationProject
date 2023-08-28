package com.example.bmgproject.data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bmgproject.data.DBModel.Currency


@Database(entities = [Currency::class], version = 1)
abstract class CurrencyDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao

}