package com.example.castshow.cast_show_feature

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.CastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.castshow.cast_show_feature.domain.model.Character
import com.example.castshow.core.network.ApiClient

@HiltViewModel
class CastListViewModel @Inject constructor(
    //private val castRepository: CastRepository
): ViewModel() {

    private lateinit var characters: List<Character>
   // var characterList by mutableStateOf<List<X>>(emptyList())
        private set
    init {
        viewModelScope.launch {
          //    characters = castRepository.getCharacters(1)

         //   ApiClient.instance.getData().getOrDefault(listOf())
        }
    }
}