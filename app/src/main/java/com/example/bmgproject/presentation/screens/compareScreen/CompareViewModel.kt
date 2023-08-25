package com.example.bmgproject.presentation.screens.compareScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

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
        }else if (text.contains(')')
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
            textSts.value = text.substring(0, text.indexOf('('))
        } else if (text.contains('(')
        ) {
            textSts.value = text.substring(0, text.indexOf('('))
        }else if (text.contains(')')
        ) {
            textSts.value = text.substring(0, text.indexOf(')'))
        }
        else {
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
        }else if (text.contains(')')
        ) {
            textStT.value = text.substring(0, text.indexOf(')'))
        }
        else {
            textStT.value = text
        }
    }

    var expendedStT= mutableStateOf(false)
    var selectedItemT= mutableStateOf("--Not Selected")

    fun onExpendedChangeT(){
        expendedStT.value=!expendedStT.value
    }
    fun onDropDownDismissT(){
        expendedStT.value=false
    }
    fun onDropDownItemClickT(selected:String){
        selectedItemT.value=selected
        expendedStT.value=false
    }

    var expendedSt= mutableStateOf(false)
    var selectedItem= mutableStateOf("--Not Selected--")
    fun onExpendChange(){
        expendedSt.value=!expendedSt.value
    }
    fun onDropDownDismiss(){
        expendedSt.value=false
    }
    fun onDropDownItemClick(selected:String){
        selectedItem.value=selected
        expendedSt.value=false
    }

    var expendedStS= mutableStateOf(false)
    var selectedItemS= mutableStateOf("--Not Selected--")
    fun onExpendedChangeS(){
        expendedStS.value=!expendedStS.value
    }
    fun onDropDownDismissS(){
        expendedStS.value=false
    }
    fun onDropDownItemClickS(selected:String){
        selectedItemS.value=selected
        expendedStS.value=false
    }

    var buttonState= mutableStateOf(false)
    fun updateState(){
        buttonState.value=!buttonState.value
    }
}