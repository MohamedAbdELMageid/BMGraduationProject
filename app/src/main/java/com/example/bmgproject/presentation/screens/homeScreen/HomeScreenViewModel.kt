package com.example.bmgproject.presentation.screens.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bmgproject.data.models.currenciesModel.currenciesList
import com.example.bmgproject.data.network.APIViewModel

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
            textSts.value = text.substring(0, text.indexOf('/'))
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

    val expended = mutableStateOf(false)
    val selectedItem = mutableStateOf<currenciesList?>(null)
    fun onExpendChange() {
        expended.value = !expended.value
    }

    fun onDismissRequest() {
        expended.value = false
    }

    fun onDropDownItemClick(selected: currenciesList) {
        selectedItem.value = selected
        expended.value = false
    }

    val expendedS = mutableStateOf(false)
    val selectedItemS = mutableStateOf<currenciesList?>(null)
    fun onExpendChangeS() {
        expendedS.value = !expendedS.value
    }

    fun onDismissRequestS() {
        expendedS.value = false
    }

    fun onDropDownItemClickS(selected: currenciesList) {
        selectedItemS.value = selected
        expendedS.value = false
    }

    private var convert = mutableStateOf(false)
    fun updateConvertState(): Boolean {
        convert.value = !convert.value
        return convert.value
    }


    private var compare = mutableStateOf(false)
    fun updateCompareState() {
        compare.value = !compare.value
    }

    private var conversion = mutableStateOf(false)
    fun updateConversionState(home: HomeScreenViewModel, api: APIViewModel) {
        if (home.textSt.value.isNotEmpty() &&
            home.selectedItem.value != null &&
            home.selectedItemS.value != null
        ) {
            api.convertTwoCurrencies(
                home.selectedItem.value!!.headLine,
                home.selectedItemS.value!!.headLine,
                home.textSt.value,
            )
            conversion.value = !conversion.value
        } else {
            conversion.value = false
        }
    }
}