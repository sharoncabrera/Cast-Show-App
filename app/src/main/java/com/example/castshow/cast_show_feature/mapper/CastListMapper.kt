package com.example.castshow.cast_show_feature.mapper

import com.example.castshow.core.domain.model.Character
import com.example.castshow.cast_show_feature.state.CharacterListItem
import com.example.castshow.core.data.entities.CharacterEntity


fun Character.toCharacterListItem(): CharacterListItem {
    return CharacterListItem(
        id = id,
        name = name
    )
}

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
    )
}