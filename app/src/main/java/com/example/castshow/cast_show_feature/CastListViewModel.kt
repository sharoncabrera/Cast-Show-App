package com.example.castshow.cast_show_feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.CastRepository
import com.example.castshow.cast_show_feature.domain.model.Character
import com.example.castshow.cast_show_feature.state.CharacterListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CastListViewModel @Inject constructor(
    private val castRepository: CastRepository
) : ViewModel() {

    private lateinit var characters: List<Character>

    var characterList by mutableStateOf<List<Character>>(
        emptyList()
    )
        private set

    var charactersSearchQuery by mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            characters = castRepository.getCharacters()
            initListOfCharacters()
        }
    }


    private fun initListOfCharacters() {

        characterList = characters

    }
}