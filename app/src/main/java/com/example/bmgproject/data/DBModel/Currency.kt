package com.example.bmgproject.data.DBModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey
    var code: String,
    val flagUrl: String,
    val desc: String,
    var isSaved:Boolean = false,
    var amount:Double=0.0
)