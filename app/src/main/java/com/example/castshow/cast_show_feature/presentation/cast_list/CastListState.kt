package com.example.castshow.cast_show_feature.presentation.cast_list

import com.example.castshow.core.data.local.model.Character

data class CastListState(
    val characters: List<Character> = listOf(),
    val filteredCharacters: List<Character> = listOf(),
    val characterName: String = "",
    val isLoading: Boolean = false
)
