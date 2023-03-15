package com.example.castshow.core.di

import android.content.Context
import androidx.room.Room
import com.example.castshow.cast_show_feature.data.repository.CastRepositoryImpl
import com.example.castshow.cast_show_feature.domain.repository.CastRepository
import com.example.castshow.core.data.CastShowDatabase
import com.example.castshow.core.data.CharacterDao
import com.example.castshow.core.network.ApiClient
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
    fun provideApi(): ApiClient {
        return ApiClient()
    }

    @Provides
    @Singleton
    fun provideCastRepository(characterDao: CharacterDao, apiClient: ApiClient): CastRepository {
        return CastRepositoryImpl(characterDao, api = apiClient)
    }

    @Provides
    @Singleton
    fun provideOrderDatabase(@ApplicationContext context: Context): CastShowDatabase {
        return Room.databaseBuilder(
            context,
            CastShowDatabase::class.java,
            "order_db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideOrderDao(database: CastShowDatabase): CharacterDao {
        return database.characterDao()
    }


}