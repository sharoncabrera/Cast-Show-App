package com.example.castshow.cast_show_feature.data.mapper

import com.example.castshow.core.data.local.entities.CharacterEntity
import com.example.castshow.core.data.local.model.Character

fun Character.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin,
        location = location,
        image = image,
        episode = episode
    )
}