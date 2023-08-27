package com.example.bmgproject.presentation.screens.compareScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bmgproject.data.models.currenciesModel.currenciesList
import com.example.bmgproject.data.network.APIViewModel

class CompareViewModel : ViewModel() {
    private var convert = mutableStateOf(false)
    fun updateConvertState() {
        convert.value = !convert.value
    }

    private var compare = mutableStateOf(false)
    fun updateCompareState() {
        compare.value = !compare.value
    }

    val textStT = mutableStateOf("1")
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
        } else if (text.contains(')')
        ) {
            textSt.value = text.substring(0, text.indexOf(')'))
        } else {
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
            textSts.value = text.substring(0, text.indexOf('('))
        } else if (text.contains('(')
        ) {
            textSts.value = text.substring(0, text.indexOf('('))
        } else if (text.contains(')')
        ) {
            textSts.value = text.substring(0, text.indexOf(')'))
        } else {
            textSts.value = text
        }
    }

    fun onValueChangeT(text: String) {
        if (text.contains('*')
        ) {
            textStT.value = text.substring(0, text.indexOf('*'))

        } else if (text.contains('#')) {
            textStT.value = text.substring(0, text.indexOf('#'))
        } else if (text.contains(',')
        ) {
            textStT.value = text.substring(0, text.indexOf(','))
        } else if (text.contains('.')
        ) {
            textStT.value = text.substring(0, text.indexOf('.'))
        } else if (text.contains(';')
        ) {
            textStT.value = text.substring(0, text.indexOf(';'))
        } else if (text.contains('+')
        ) {
            textStT.value = text.substring(0, text.indexOf('+'))
        } else if (text.contains('-')
        ) {
            textStT.value = text.substring(0, text.indexOf('-'))
        } else if (text.contains('N')
        ) {
            textStT.value = text.substring(0, text.indexOf('N'))
        } else if (text.contains(" ")
        ) {
            textStT.value = text.substring(0, text.indexOf(' '))
        } else if (text.contains('/')
        ) {
            textStT.value = text.substring(0, text.indexOf('/'))
        } else if (text.contains('(')
        ) {
            textStT.value = text.substring(0, text.indexOf('('))
        } else if (text.contains(')')
        ) {
            textStT.value = text.substring(0, text.indexOf(')'))
        } else {
            textStT.value = text
        }
    }


    var expendedSt = mutableStateOf(false)
    var selectedItem = mutableStateOf<currenciesList?>(null)
    fun onExpendChange() {
        expendedSt.value = !expendedSt.value
    }

    fun onDropDownDismiss() {
        expendedSt.value = false
    }

    fun onDropDownItemClick(selected: currenciesList) {
        selectedItem.value = selected
        expendedSt.value = false
    }

    var expendedStS = mutableStateOf(false)
    var selectedItemS = mutableStateOf<currenciesList?>(null)
    fun onExpendedChangeS() {
        expendedStS.value = !expendedStS.value
    }

    fun onDropDownDismissS() {
        expendedStS.value = false
    }

    fun onDropDownItemClickS(selected: currenciesList) {
        selectedItemS.value = selected
        expendedStS.value = false
    }

    var expendedStT = mutableStateOf(false)
    var selectedItemT = mutableStateOf<currenciesList?>(null)
    fun onExpendedChangeT() {
        expendedStT.value = !expendedStT.value
    }

    fun onDropDownDismissT() {
        expendedStT.value = false
    }


    fun onDropDownItemClickT(selected: currenciesList) {
        selectedItemT.value = selected
        expendedStT.value = false
    }

    var buttonState = mutableStateOf(false)
    fun updateState(api: APIViewModel) {
        if (textSt.value.isNotEmpty() &&
            selectedItem.value != null &&
            selectedItemS.value != null &&
            selectedItemT.value != null
        ) {
            api.convertFirstCurrencies(
                selectedItem.value!!.headLine,
                selectedItemS.value!!.headLine,
                textSt.value
            )
            api.convertSecondCurrencies(
                selectedItem.value!!.headLine,
                selectedItemT.value!!.headLine,
                textSt.value
            )
            buttonState.value = !buttonState.value
        } else {
            buttonState.value = false
        }
    }


}