package app.madar.alaamadarsoft.ui.people.viewmodel

import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.MainDispatcherRule
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
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
        val collectionList = mutableListOf<PeopleUiState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.peopleUiState.collectLatest { collectionList.add(it) }
        }

        // When
        viewModel.updatePeopleUiState()

        // Then
        advanceUntilIdle()
        val result = collectionList[1]
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_people_fetch_is_success_then_people_ui_state_is_success() = runTest {
        // Given
        val expectedResult = PeopleUiState.Success(emptyList())
        val viewModel = PeopleViewModel(mockPeopleRepository)
        val collectionList = mutableListOf<PeopleUiState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.peopleUiState.collectLatest { collectionList.add(it) }
        }
        coEvery { mockPeopleRepository.getPeople() } returns emptyList()

        // When
        viewModel.updatePeopleUiState()

        // Then
        advanceUntilIdle()
        val result = collectionList[2]
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_people_fetch_is_error_then_people_ui_state_is_error() = runTest {
        // Given
        val expectedResult = PeopleUiState.Error("Failed to get People :(")
        val viewModel = PeopleViewModel(mockPeopleRepository)
        val collectionList = mutableListOf<PeopleUiState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.peopleUiState.collectLatest { collectionList.add(it) }
        }
        coEvery { mockPeopleRepository.getPeople() } throws Exception("Failed to get People :(")

        // When
        viewModel.updatePeopleUiState()

        // Then
        advanceUntilIdle()
        val result = collectionList[2]
        assertEquals(expectedResult, result)
    }
}