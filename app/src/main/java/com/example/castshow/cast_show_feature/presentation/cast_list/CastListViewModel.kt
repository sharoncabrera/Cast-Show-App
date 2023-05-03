package com.example.castshow.cast_show_feature.presentation.cast_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.use_case.FilterListByNameUseCase
import com.example.castshow.cast_show_feature.domain.use_case.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CastListViewModel @Inject constructor(
    private val filterListByNameUseCase: FilterListByNameUseCase,
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    var state by mutableStateOf(CastListState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            state = state.copy(
                characters = getCharactersUseCase()
            )
            setupCharactersToShow()
        }
    }

    private fun getMoreCharacters() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )

            val characters = state.characters
            val newCharacters = getCharactersUseCase()

            state = state.copy(
                characters = characters + newCharacters,
            )
            setupCharactersToShow()
        }
    }

    private fun onSearchQueryChange(newValue: String) {
        state = state.copy(
            characterName = newValue
        )
        setupCharactersToShow()
    }

    private fun setupCharactersToShow() {
        state = state.copy(
            isLoading = false
        )

        val charactersToShow = filterListByNameUseCase(
            state.characters, state.characterName
        )

        state = state.copy(
            filteredCharacters = charactersToShow
        )
    }

    fun onTriggerEvent(event: CastListEvents) {
        when (event) {
            is CastListEvents.GetMoreCharacters -> {
                getMoreCharacters()
            }

            is CastListEvents.FilterCharacters -> {
            }

            is CastListEvents.UpdateCharacterName -> {
                onSearchQueryChange(event.characterName)
            }
        }
    }

}