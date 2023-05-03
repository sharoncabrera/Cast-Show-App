package com.example.castshow.core.data.mapper

import com.example.castshow.core.data.local.entities.CharacterEntity
import com.example.castshow.core.data.local.model.Character

fun CharacterEntity.toCharacter(): Character {
    return Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin,
        location,
        image,
        episode
    )
}