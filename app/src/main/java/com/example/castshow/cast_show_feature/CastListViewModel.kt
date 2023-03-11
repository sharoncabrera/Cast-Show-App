package com.example.castshow.cast_show_feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.model.Character
import com.example.castshow.cast_show_feature.state.CharacterListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CastListViewModel @Inject constructor(
    //private val castRepository: CastRepository
) : ViewModel() {

    private lateinit var characters: List<Character>

    //TODO: emptyList()
    var characterList by mutableStateOf<List<CharacterListItem>>(
        //TODO: por el momento: mock data
        listOf(
            CharacterListItem(1),
            CharacterListItem(2),
            CharacterListItem(3),
            CharacterListItem(4),
            CharacterListItem(5),
            CharacterListItem(6),
            CharacterListItem(7),
            CharacterListItem(8),
            CharacterListItem(9),
            CharacterListItem(10),
            CharacterListItem(11),
            CharacterListItem(12)
        )
    )
        private set

    init {
        viewModelScope.launch {
            //    characters = castRepository.getCharacters(1)

            //   ApiClient.instance.getData().getOrDefault(listOf())
        }
    }
}