package com.example.castshow.cast_show_feature.domain.repository

import com.example.castshow.core.data.local.model.Character

interface CastRepository {

    suspend fun getCharactersFromApi(status: String = "", gender: String = ""): List<Character>
    suspend fun getCharactersFromDb(): List<Character>
    suspend fun getCharacterById(characterId: Int): Character
    suspend fun insertCharacter(character: Character)


}