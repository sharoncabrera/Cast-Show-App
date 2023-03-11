package com.example.castshow.cast_show_feature.domain

import com.example.castshow.cast_show_feature.domain.model.Character

interface CastRepository {

    suspend fun getCharacters(page: Int): List<Character>
    suspend fun getDetailedInfoCharacter(id: String): Character
}