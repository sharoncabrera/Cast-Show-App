package com.example.castshow.cast_show_feature.data.repository

import com.example.castshow.cast_show_feature.components.mapper.toCharacter
import com.example.castshow.cast_show_feature.domain.CastRepository
import com.example.castshow.cast_show_feature.domain.use_case.model.Character
import com.example.castshow.core.network.ApiClient
import javax.inject.Inject

class CastRepositoryImpl @Inject constructor(
) : CastRepository {
    override suspend fun getCharacters(): List<Character> {

        ApiClient.instance = ApiClient()
        return ApiClient.instance.getData().getOrDefault(listOf()).map {
            it.toCharacter()
        }
    }

    override suspend fun getDetailedInfoCharacter(id: String): Character {
        TODO("Not yet implemented")
    }
}