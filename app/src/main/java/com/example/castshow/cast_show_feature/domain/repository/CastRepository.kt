package com.example.castshow.cast_show_feature.domain.repository

import com.example.castshow.core.domain.model.Character

interface CastRepository {

    suspend fun getCharacters(): List<Character>
    suspend fun getCharactersFilteredBy(status: String, gender: String): List<Character>
    suspend fun getCharacterById(characterId: Int): Character
    suspend fun insertCharacter(character: Character)


}