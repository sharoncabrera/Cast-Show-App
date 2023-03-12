package com.example.castshow.cast_show_feature.mapper

import com.example.castshow.cast_show_feature.domain.use_case.model.Character
import com.example.castshow.cast_show_feature.state.CharacterListItem


fun Character.toCharacterListItem(): CharacterListItem {
    return CharacterListItem(
        id = id,
        name = name
    )
}