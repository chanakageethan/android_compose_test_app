package com.example.composemvvmtestapp.di

import android.app.Application
import androidx.room.Room
import com.example.composemvvmtestapp.data.ConverterDatabase
import com.example.composemvvmtestapp.data.ConverterRepository
import com.example.composemvvmtestapp.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application): ConverterDatabase {
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            name = "converter_data_database",
        ).build()
    }


    @Provides
    @Singleton
    fun providesConverterRepository(db: ConverterDatabase): ConverterRepository {
        return ConverterRepositoryImpl(db.converterDAO)
    }

}