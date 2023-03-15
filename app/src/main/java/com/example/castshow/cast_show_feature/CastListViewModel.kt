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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value = true
            characters = getCharactersUseCase()
            setupCharactersToShow()
        }
    }

    fun getMoreCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            characters = characters + getCharactersUseCase()
            setupCharactersToShow()
        }
    }

    fun onSearchQueryChange(newValue: String) {
        charactersSearchQuery = newValue
        setupCharactersToShow()
    }

    private fun setupCharactersToShow() {
        _isLoading.value = false
        charactersToShow = filterListByNameUseCase(
            characters, charactersSearchQuery
        )
    }
}