package com.example.composemvvmtestapp.compose.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.composemvvmtestapp.data.ConvertionResult

@Composable
fun HistoryScreen(
    list: State<List<ConvertionResult>>,
    modifier: Modifier = Modifier
) {

    HistoryList(list = list, onCloseTask = {})


}