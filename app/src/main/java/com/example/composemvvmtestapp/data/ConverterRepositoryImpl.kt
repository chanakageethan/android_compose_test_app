package com.example.composemvvmtestapp.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao:ConverterDAO) :ConverterRepository {
    override suspend fun insertResult(result: ConvertionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConvertionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConvertionResult>> {
        return  dao.getResults()
    }
}