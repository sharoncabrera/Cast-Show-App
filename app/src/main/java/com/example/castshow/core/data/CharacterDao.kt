package com.example.castshow.core.data

import androidx.room.*
import com.example.castshow.core.data.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(productEntity: CharacterEntity)


    @Query("SELECT * FROM CharacterEntity WHERE id = :characterId")
    suspend fun getCharacter(characterId: Int): CharacterEntity

    @Transaction
    @Query("SELECT * FROM CharacterEntity")
    suspend fun getCharacters(): List<CharacterEntity>

}