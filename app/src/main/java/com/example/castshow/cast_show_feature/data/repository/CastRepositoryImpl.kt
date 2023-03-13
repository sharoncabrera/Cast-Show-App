package com.example.castshow.cast_show_feature.data.repository

import com.example.castshow.cast_show_feature.components.mapper.toCharacter
import com.example.castshow.cast_show_feature.domain.repository.CastRepository
import com.example.castshow.cast_show_feature.mapper.toCharacterEntity
import com.example.castshow.core.data.CharacterDao
import com.example.castshow.core.data.mapper.toCharacter
import com.example.castshow.core.domain.model.Character
import com.example.castshow.core.network.ApiClient
import javax.inject.Inject

class CastRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao
) : CastRepository {
    override suspend fun getCharacters(): List<Character> {
        //TODO:mpreguntar a Iván!!
        ApiClient.instance = ApiClient()
        return ApiClient.instance.getData().getOrDefault(listOf()).map {
            insertCharacter(it.toCharacter())
            it.toCharacter()
        }


    }

    override suspend fun getCharactersFilteredBy(status: String, gender: String): List<Character> {
        return ApiClient.instance.getDataFilteredBy(status = status, gender = gender)
            .getOrDefault(listOf()).map {
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