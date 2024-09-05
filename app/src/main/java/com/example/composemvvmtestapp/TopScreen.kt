package com.example.composemvvmtestapp

import android.icu.text.DecimalFormat
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.math.RoundingMode

@Composable
fun TopScreen(list: List<Conversion>) {
    val selectedConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember {
        mutableStateOf("")
    }
    val typedValue = remember { mutableStateOf("0.0") }

    ConvertionMenu(list = list) {
        selectedConversion.value = it
    }
    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->

            typedValue.value = input

        }
    }


    if(typedValue.value != "0.0"){
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply


        val df = DecimalFormat("#.####")
        df.roundingMode =RoundingMode.DOWN.ordinal
        val roundedResult = df.format(result)

        val message1 =  "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"

        ResultBlock(message1 = message1, message2 = message2 )


    }
}