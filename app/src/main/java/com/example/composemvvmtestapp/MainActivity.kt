package com.example.composemvvmtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.composemvvmtestapp.compose.BaseScreen
import com.example.composemvvmtestapp.data.ConverterDatabase
import com.example.composemvvmtestapp.data.ConverterRepository
import com.example.composemvvmtestapp.data.ConverterRepositoryImpl
import com.example.composemvvmtestapp.ui.theme.ComposeMVVMTestAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory:ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val dao = ConverterDatabase.getInstance(application).converterDAO
//        val repository = ConverterRepositoryImpl(dao)
//        val factory = ConverterViewModelFactory(repository)



        enableEdgeToEdge()
        setContent {
            ComposeMVVMTestAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()

                ) { innerPadding ->
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}

