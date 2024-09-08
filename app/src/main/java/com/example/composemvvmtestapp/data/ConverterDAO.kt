package com.example.composemvvmtestapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ConverterDAO {

    @Insert
    suspend fun insertResult(result: ConvertionResult)

    @Delete
    suspend fun deleteResult(result: ConvertionResult)

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM result_table")
    fun getResults(): Flow<List<ConvertionResult>>


}