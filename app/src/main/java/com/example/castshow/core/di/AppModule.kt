package com.example.castshow.core.di

import com.example.castshow.cast_show_feature.data.repository.CastRepositoryImpl
import com.example.castshow.cast_show_feature.domain.CastRepository
import com.example.castshow.core.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCastRepository(): CastRepository {
        return CastRepositoryImpl()
    }
}