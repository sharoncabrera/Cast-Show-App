package com.example.castshow

import androidx.lifecycle.SavedStateHandle
import com.example.castshow.cast_show_feature.presentation.DetailedInfoViewModel
import com.example.castshow.cast_show_feature.domain.use_case.GetCharacterByIdUseCase
import com.example.castshow.cast_show_feature.domain.use_case.GetCharactersUseCase
import com.example.castshow.core.data.local.model.Character
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailedInfoViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var viewModel: DetailedInfoViewModel
    private var savedStateHandle: SavedStateHandle = mockk<SavedStateHandle>(relaxed = true)
    private var getCharacterByIdUseCase: GetCharacterByIdUseCase = mockk()
    private val getCharactersUseCase: GetCharactersUseCase = mockk()


    @Before
    fun setUp() {

    }

    @Test
    fun `should set characterItem to default value when GetCharacterByIdUseCase returns error`() = runTest {
        val characterId = "1"

        every { savedStateHandle.get<String>(DetailedInfoViewModel.CHARACTER_ID_SAVED_STATE_KEY) } returns characterId
        coEvery { getCharacterByIdUseCase(characterId.toInt()) }


        // Create the DetailedInfoViewModel instance with the mocked dependencies
        viewModel = DetailedInfoViewModel(savedStateHandle, getCharacterByIdUseCase)

        // Mock the GetCharacterByIdUseCase to throw an exception
        advanceUntilIdle()
        // Verify that the characterItem property is set to the default value
        assertEquals(Character(id = 3), viewModel.characterItem)
    }
}