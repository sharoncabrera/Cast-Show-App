package com.example.castshow

import com.example.castshow.cast_show_feature.CastListViewModel
import com.example.castshow.cast_show_feature.domain.use_case.FilterListByNameUseCase
import com.example.castshow.cast_show_feature.domain.use_case.GetCharactersUseCase
import com.example.castshow.core.data.model.Character
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CastListViewModelTest {

    @MockK
    private lateinit var filterListByNameUseCase: FilterListByNameUseCase

    @MockK
    private lateinit var getCharactersUseCase: GetCharactersUseCase

/*
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

 */


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when get the characters then the expected list size`() = runTest(UnconfinedTestDispatcher()) {

        val sut = CastListViewModel(
            filterListByNameUseCase,
            getCharactersUseCase
        )

        val expectedItem = listOf(Character(id = 1))

        coEvery {
            getCharactersUseCase()
        } returns listOf(Character(id = 1))

        assertEquals(expectedItem, sut.charactersToShow.size)
    }
}