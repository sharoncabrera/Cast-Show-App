package com.example.castshow.cast_show_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castshow.cast_show_feature.domain.use_case.GetCharacterByIdUseCase
import com.example.castshow.core.data.local.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailedInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val characterId: String? = savedStateHandle.get<String>(CHARACTER_ID_SAVED_STATE_KEY)
    private lateinit var character: Character
    var characterItem by mutableStateOf<Character>(Character(3))
        private set

    init {
        viewModelScope.launch {
            characterId?.let {
                character = getCharacterByIdUseCase(it.toInt())
                characterItem = character
            }
        }
    }

    companion object {
        const val CHARACTER_ID_SAVED_STATE_KEY = "characterId"
    }
}