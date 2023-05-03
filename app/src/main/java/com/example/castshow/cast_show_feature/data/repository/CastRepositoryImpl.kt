package com.example.castshow.cast_show_feature.data.repository

import com.example.castshow.cast_show_feature.data.mapper.toDomain
import com.example.castshow.cast_show_feature.domain.repository.CastRepository
import com.example.castshow.cast_show_feature.data.mapper.toCharacterEntity
import com.example.castshow.core.data.local.CharacterDao
import com.example.castshow.core.data.mapper.toCharacter
import com.example.castshow.core.data.local.model.Character
import com.example.castshow.core.network.ApiClient
import javax.inject.Inject

class CastRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val api: ApiClient
) : CastRepository {
    override suspend fun getCharactersFromApi(status: String, gender: String): List<Character> {
        return api.getData(status = status, gender = gender).getOrDefault(listOf()).map {
            insertCharacter(it.toDomain())
            it.toDomain()
        }
    }

    override suspend fun getCharactersFromDb(): List<Character> {
        return characterDao.getCharacters().map {
            it.toCharacter()
        }
    }

    override suspend fun getCharacterById(characterId: Int): Character {
        return characterDao.getCharacter(characterId).toCharacter()
    }

    override suspend fun insertCharacter(character: Character) {
        characterDao.insertCharacter(character.toCharacterEntity())
    }

}