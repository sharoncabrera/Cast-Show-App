package com.example.castshow.cast_show_feature.di

import com.example.castshow.cast_show_feature.domain.use_case.FilterListByNameUseCase
import com.example.castshow.cast_show_feature.domain.use_case.SortedListByNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CastFeatureModule {

    @Provides
    @Singleton
    fun provideFilterByNameUseCase(): FilterListByNameUseCase {
        return FilterListByNameUseCase()
    }

    @Provides
    @Singleton
    fun provideSortedByNameUseCase(): SortedListByNameUseCase {
        return SortedListByNameUseCase()
    }

}

