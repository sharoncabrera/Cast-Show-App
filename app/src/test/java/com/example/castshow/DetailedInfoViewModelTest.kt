package com.example.castshow

import androidx.lifecycle.SavedStateHandle
import com.example.castshow.cast_show_feature.domain.use_case.GetCharacterByIdUseCase
import com.example.castshow.cast_show_feature.presentation.cast_detail.CastDetailState
import com.example.castshow.cast_show_feature.presentation.cast_detail.DetailedInfoViewModel
import com.example.castshow.core.data.local.model.Character
import io.mockk.every
import io.mockk.mockk
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
    private var viewModel: DetailedInfoViewModel = mockk(relaxed = true)
    private var savedStateHandle: SavedStateHandle = mockk(relaxed = true)
    private var getCharacterByIdUseCase: GetCharacterByIdUseCase = mockk(relaxed = true)

    @Before
    fun setUp() {

    }

    @Test
    fun `should update state with default values when characterId is null`() = runTest {
        // given
        every { savedStateHandle.get<String>("characterId") } returns null

        // when
        viewModel = DetailedInfoViewModel(savedStateHandle, getCharacterByIdUseCase)

        advanceUntilIdle()
        // then
        assertEquals(mockDefaultState, viewModel.state)
    }

    companion object {
        val mockCharacter = Character(id = 1, name = "Sharon Cabrera")
        val mockState = CastDetailState(character = mockCharacter)
        val mockDefaultState = CastDetailState()
    }
}

