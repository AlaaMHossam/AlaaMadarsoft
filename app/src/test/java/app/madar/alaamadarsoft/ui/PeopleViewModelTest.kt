package app.madar.alaamadarsoft.ui

import app.madar.alaamadarsoft.ui.states.PeopleUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PeopleViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun when_update_people_state_then_ui_state_is_loading() = runTest {
        // Given
        val expectedResult = PeopleUiState.Loading
        val viewModel = PeopleViewModel()

        // When
        viewModel.updatePeopleUiState()

        // Then
        advanceUntilIdle()
        val result = viewModel.peopleUiState.value
        assertEquals(expectedResult, result)
    }
}