package com.example.bmgproject.presentation.screens.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

    val textSts = mutableStateOf("1")
    val textSt = mutableStateOf("1")
    fun onValueChange(text: String) {
        if (text.contains('*')
                ) {
            textSt.value = text.substring(0, text.indexOf('*'))

        } else if (text.contains('#')) {
            textSt.value = text.substring(0, text.indexOf('#'))
        } else if (text.contains(',')
        ) {
            textSt.value = text.substring(0, text.indexOf(','))
        } else if (text.contains('.')
        ) {
            textSt.value = text.substring(0, text.indexOf('.'))
        } else if (text.contains(';')
        ) {
            textSt.value = text.substring(0, text.indexOf(';'))
        } else if (text.contains('+')
        ) {
            textSt.value = text.substring(0, text.indexOf('+'))
        } else if (text.contains('-')
        ) {
            textSt.value = text.substring(0, text.indexOf('-'))
        } else if (text.contains('N')
        ) {
            textSt.value = text.substring(0, text.indexOf('N'))
        } else if (text.contains(" ")
        ) {
            textSt.value = text.substring(0, text.indexOf(' '))
        } else if (text.contains('/')
        ) {
            textSt.value = text.substring(0, text.indexOf('/'))
        } else if (text.contains('(')
        ) {
            textSt.value = text.substring(0, text.indexOf('('))
        }
        else if (text.contains(')')
        ) {
            textSt.value = text.substring(0, text.indexOf(')'))
        }
        else {
            textSt.value = text
        }
    }

    fun onValueChangeS(text: String) {
        if (text.contains('*')
        ) {
            textSts.value = text.substring(0, text.indexOf('*'))

        } else if (text.contains('#')) {
            textSts.value = text.substring(0, text.indexOf('#'))
        } else if (text.contains(',')
        ) {
            textSts.value = text.substring(0, text.indexOf(','))
        } else if (text.contains('.')
        ) {
            textSts.value = text.substring(0, text.indexOf('.'))
        } else if (text.contains(';')
        ) {
            textSts.value = text.substring(0, text.indexOf(';'))
        } else if (text.contains('+')
        ) {
            textSts.value = text.substring(0, text.indexOf('+'))
        } else if (text.contains('-')
        ) {
            textSts.value = text.substring(0, text.indexOf('-'))
        } else if (text.contains('N')
        ) {
            textSts.value = text.substring(0, text.indexOf('N'))
        } else if (text.contains(" ")
        ) {
            textSts.value = text.substring(0, text.indexOf(' '))
        } else if (text.contains('/')
        ) {
            textSts.value = text.substring(0, text.indexOf('/'))
        } else if (text.contains('(')
        ) {
            textSts.value = text.substring(0, text.indexOf('('))
        }else if (text.contains(')')
        ) {
            textSts.value = text.substring(0, text.indexOf(')'))
        }
        else {
            textSts.value = text
        }    }

    val expended = mutableStateOf(false)
    val selectedItem = mutableStateOf("--Not Selected--")
    fun onExpendChange() {
        expended.value = !expended.value
    }

    fun onDismissRequest() {
        expended.value = false
    }

    fun onDropDownItemClick(selected: String) {
        selectedItem.value = selected
        expended.value = false
    }

    val expendedS = mutableStateOf(false)
    val selectedItemS = mutableStateOf("--Not Selected--")
    fun onExpendChangeS() {
        expendedS.value = !expendedS.value
    }

    fun onDismissRequestS() {
        expendedS.value = false
    }

    fun onDropDownItemClickS(selected: String) {
        selectedItemS.value = selected
        expendedS.value = false
    }

    private var conversionSt = mutableStateOf(false)
    fun updateConversionState(): Boolean {
        conversionSt.value = !conversionSt.value
        return conversionSt.value
    }

    private var convert = mutableStateOf(false)
    fun updateConvertState() {
        convert.value = !convert.value
    }

    private var compare = mutableStateOf(false)
    fun updateCompareState() {
        compare.value = !compare.value
    }
}