package com.example.castshow.core.data.mapper

import com.example.castshow.core.data.entities.CharacterEntity
import com.example.castshow.core.domain.model.Character

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
    )
}