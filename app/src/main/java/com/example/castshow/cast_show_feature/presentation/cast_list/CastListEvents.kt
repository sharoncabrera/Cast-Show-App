package com.example.castshow.cast_show_feature.presentation.cast_list

sealed class CastListEvents {

    object GetMoreCharacters : CastListEvents()

    object FilterCharacters : CastListEvents()

    data class UpdateCharacterName(
        val characterName: String,
    ) : CastListEvents()

}