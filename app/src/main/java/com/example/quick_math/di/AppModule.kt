package com.example.quick_math.di

import android.content.Context
import com.example.quick_math.data.LocalUserStatisticsRepositoryImpl
import com.example.quick_math.data.statisticsDataStore
import com.example.quick_math.domain.IStatisticsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserStatistics(
        @ApplicationContext app: Context
    ): IStatisticsRepository = LocalUserStatisticsRepositoryImpl(app.statisticsDataStore)
}