package com.example.castshow

import com.example.castshow.cast_show_feature.presentation.cast_list.CastListViewModel
import com.example.castshow.cast_show_feature.domain.use_case.FilterListByNameUseCase
import com.example.castshow.cast_show_feature.domain.use_case.GetCharactersUseCase
import com.example.castshow.core.data.local.model.Character
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CastListViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CastListViewModel

    private val filterListByNameUseCase: FilterListByNameUseCase = FilterListByNameUseCase()

    private val getCharactersUseCase: GetCharactersUseCase = mockk()

    @Before
    fun setup() {
        val characters = listOf(
            Character(id = 1, name = "Alice"),
            Character(id = 2, name = "Bob"),
            Character(id = 3, name = "Charlie"),
            Character(id = 4, name = "David")
        )
        coEvery { getCharactersUseCase() } returns characters

        viewModel = CastListViewModel(filterListByNameUseCase, getCharactersUseCase)

    }

    @Test
    fun `getMoreCharacters adds more characters to the list`() = runTest {
        // Given
        val newCharacters =
            listOf(Character(id = 5, name = "Marc"), Character(id = 5, name = "Michelle"))

        // When
        coEvery { getCharactersUseCase() } returns newCharacters
        viewModel.getMoreCharacters()
        // Then
        advanceUntilIdle()
        assertEquals(
            listOf(
                Character(id = 1, name = "Alice"),
                Character(id = 2, name = "Bob"),
                Character(id = 3, name = "Charlie"),
                Character(id = 4, name = "David")
            ) + newCharacters, viewModel.charactersToShow
        )
    }

    @Test
    fun `charactersToShow should be updated correctly on search query change`() = runTest {
        // Given
        val characters = listOf(
            Character(id = 1, "John"),
            Character(id = 2, "Jane")
        )
        coEvery { getCharactersUseCase() } returns characters
        viewModel.getMoreCharacters()

        // When
        viewModel.onSearchQueryChange("John")

        // Then
        advanceUntilIdle()
        assertEquals(listOf(characters[0]), viewModel.charactersToShow)
    }
}