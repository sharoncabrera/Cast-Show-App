package com.example.castshow.cast_show_feature.domain

import com.example.castshow.cast_show_feature.domain.use_case.model.Character

interface CastRepository {

    suspend fun getCharacters(): List<Character>
    suspend fun getDetailedInfoCharacter(id: String): Character
}