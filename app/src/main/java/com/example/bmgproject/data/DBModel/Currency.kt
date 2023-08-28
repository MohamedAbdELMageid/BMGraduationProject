package com.example.bmgproject.data.DBModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey
    var code: String,
    var isSaved: Boolean = false,
)