package com.example.castshow.core.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.castshow.core.data.model.LocationResponse
import com.example.castshow.core.data.model.OriginResponse

@Entity
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
    val episode: Int
)
