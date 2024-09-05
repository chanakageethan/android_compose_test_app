package com.example.composemvvmtestapp
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TopScreen(list: List<Conversion>) {
    val selectedConversion :MutableState<Conversion?> =  remember{ mutableStateOf(null) }
    val inputText:MutableState<String> = remember {
        mutableStateOf("")
    }
    ConvertionMenu(list = list){
                selectedConversion.value = it
    }
    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText =inputText  ){input->

            Log.i("===",input)

        }
    }
}