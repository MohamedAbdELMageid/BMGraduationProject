package com.example.bmgproject

import android.content.Context

object AppContext {
    lateinit var appContext: Context

    fun initContext(context: Context){
        appContext =context
        }
}