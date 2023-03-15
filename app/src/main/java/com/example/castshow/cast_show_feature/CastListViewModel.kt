package com.example.castshow.cast_show_feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.use_case.FilterListByNameUseCase
import com.example.castshow.cast_show_feature.domain.use_case.GetCharactersUseCase
import com.example.castshow.core.data.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CastListViewModel @Inject constructor(
    private val filterListByNameUseCase: FilterListByNameUseCase,
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    var charactersToShow by mutableStateOf<List<Character>>(emptyList())

    private var characters: List<Character> = (emptyList())

    var charactersSearchQuery by mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            characters = getCharactersUseCase()
            setupCharactersToShow()
        }
    }

    fun getMoreCharacters() {
        viewModelScope.launch {
            characters = characters + getCharactersUseCase()
            setupCharactersToShow()
        }
    }

    fun onSearchQueryChange(newValue: String) {
        charactersSearchQuery = newValue
        setupCharactersToShow()
    }

    private fun setupCharactersToShow() {
        charactersToShow = filterListByNameUseCase(
            characters, charactersSearchQuery
        )
    }
}