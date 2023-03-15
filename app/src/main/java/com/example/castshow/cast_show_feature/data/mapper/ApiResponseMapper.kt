package com.example.castshow.cast_show_feature.data.mapper

import com.example.castshow.core.data.model.Character
import com.example.castshow.core.data.model.CharacterResponse

fun CharacterResponse.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        image = image,
        origin = origin.name,
        location = location.name,
        episode = episode.size
    )
}