package com.example.castshow.cast_show_feature.data.mapper

import com.example.castshow.core.data.local.model.Character
import com.example.castshow.core.data.local.model.CharacterDTO

fun CharacterDTO.toDomain(): Character {
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