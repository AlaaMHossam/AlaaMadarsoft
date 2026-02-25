package app.madar.alaamadarsoft.ui.people.viewmodel

import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.MainDispatcherRule
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PeopleViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val mockPeopleRepository = mockk<PeopleRepository>(relaxed = true)

    @Test
    fun when_update_people_state_then_ui_state_is_loading() = runTest {
        // Given
        val expectedResult = PeopleUiState.Loading
        val viewModel = PeopleViewModel(mockPeopleRepository)

        // When

        // Then
        advanceUntilIdle()
        val result = viewModel.peopleUiState.drop(1).first()
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_people_fetch_is_success_then_people_ui_state_is_success() = runTest {
        // Given
        val expectedResult = PeopleUiState.Success(emptyList())
        coEvery { mockPeopleRepository.getPeople() } returns flow { emit(emptyList()) }
        val viewModel = PeopleViewModel(mockPeopleRepository)

        // When

        // Then
        advanceUntilIdle()
        val result = viewModel.peopleUiState.drop(1).first()
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_people_fetch_is_error_then_people_ui_state_is_error() = runTest {
        // Given
        val message = "Failed to get People :("
        val expectedResult = PeopleUiState.Error(message)
        coEvery { mockPeopleRepository.getPeople() } returns flow { throw Exception(message) }
        val viewModel = PeopleViewModel(mockPeopleRepository)

        // When

        // Then
        advanceUntilIdle()
        val result = viewModel.peopleUiState.drop(1).first()
        assertEquals(expectedResult, result)
    }
}