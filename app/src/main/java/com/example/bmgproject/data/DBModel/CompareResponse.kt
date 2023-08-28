package com.example.bmgproject.data.DBModel

import com.google.gson.annotations.SerializedName

data class CompareResponse(
    @SerializedName("")
    val comparisonRates: List<ComparisonRate>,
    @SerializedName("")
    val timeLastUpdateUtc:String
)