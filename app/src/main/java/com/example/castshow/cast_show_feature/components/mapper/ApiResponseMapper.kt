package com.example.castshow.cast_show_feature.components.mapper

import com.example.castshow.core.domain.model.Character
import com.example.castshow.core.domain.model.CharacterResponse

fun CharacterResponse.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        image = image,
        origin = origin.name,
        location = location.name
    )
}