package com.example.bmgproject.data.DBModel

import com.google.gson.annotations.SerializedName

data class ConvertResponse(
    val result: Double,
    @SerializedName("")
    val timeLastUpdateUtc:String
)