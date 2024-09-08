package com.example.composemvvmtestapp.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    suspend fun insertResult(result: ConvertionResult)
    suspend fun deleteResult(result: ConvertionResult)
    suspend fun deleteAllResults()
    fun getSavedResults(): Flow<List<ConvertionResult>>
}