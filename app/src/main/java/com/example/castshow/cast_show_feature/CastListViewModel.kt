package com.example.castshow.cast_show_feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.repository.CastRepository
import com.example.castshow.cast_show_feature.domain.use_case.FilterListByNameUseCase
import com.example.castshow.cast_show_feature.domain.use_case.SortedListByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.castshow.core.domain.model.Character

@HiltViewModel
class CastListViewModel @Inject constructor(
    private val castRepository: CastRepository,
    private val sortedListByNameUseCase: SortedListByNameUseCase,
    private val filterListByNameUseCase: FilterListByNameUseCase
) : ViewModel() {

    var charactersToShow by mutableStateOf<List<Character>>(emptyList())
        private set

    private lateinit var characters: List<Character>

    private var characterList by mutableStateOf<List<Character>>(
        emptyList()
    )
        private set

    var charactersSearchQuery by mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            characters = castRepository.getCharacters()
            //TODO: hay algo raro
            characterList = characters
            setupCharactersToShow()
        }
    }

    fun onSearchQueryChange(newValue: String) {
        charactersSearchQuery = newValue
        setupCharactersToShow()
    }

    private fun setupCharactersToShow() {
        charactersToShow = filterListByNameUseCase(
            /*sortedListByNameUseCase(characters)*/characters, charactersSearchQuery
        )
    }

    fun filterBy(status: String = "", gender: String = "") {
        viewModelScope.launch {
            charactersToShow = castRepository.getCharactersFilteredBy(status, gender)
        }
    }


}