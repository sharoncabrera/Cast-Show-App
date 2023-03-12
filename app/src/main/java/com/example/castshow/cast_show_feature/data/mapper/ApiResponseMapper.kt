package com.example.castshow.cast_show_feature.data.mapper

import com.example.castshow.cast_show_feature.domain.model.Character
import com.example.castshow.core.data.CharacterResponse

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