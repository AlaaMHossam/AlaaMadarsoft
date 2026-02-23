package app.madar.alaamadarsoft.ui.add_person.viewmodel

import app.madar.alaamadarsoft.domain.model.Gender
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.MainDispatcherRule
import app.madar.alaamadarsoft.ui.states.AddPersonUiState
import app.madar.alaamadarsoft.ui.states.PersonInputState
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
class AddPersonViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val mockPeopleRepository = mockk<PeopleRepository>(relaxed = true)

    @Test
    fun when_add_person_then_ui_state_is_loading() = runTest {
        // Given
        val expectedResult = AddPersonUiState.Loading
        val viewModel = AddPersonViewModel(mockPeopleRepository)
        val collectionList = mutableListOf<AddPersonUiState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.addPersonUiState.collectLatest { collectionList.add(it) }
        }

        // When
        viewModel.updatePersonInputState {
            PersonInputState(
                "Alaa",
                "37",
                "Senior Android Developer",
                "Male"
            )
        }
        viewModel.addPerson()

        // Then
        advanceUntilIdle()
        val result = collectionList[0]
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_add_person_is_success_then_add_person_ui_state_is_success() = runTest {
        // Given
        val expectedResult = AddPersonUiState.Success("Person Added")
        val viewModel = AddPersonViewModel(mockPeopleRepository)
        val collectionList = mutableListOf<AddPersonUiState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.addPersonUiState.collect { collectionList.add(it) }
        }

        // When
        viewModel.updatePersonInputState {
            PersonInputState(
                "Alaa",
                "37",
                "Senior Android Developer",
                "Male"
            )
        }
        viewModel.addPerson()

        // Then
        advanceUntilIdle()
        val result = collectionList[1]
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_add_person_is_error_then_add_person_ui_state_is_error() = runTest {
        // Given
        val expectedResult = AddPersonUiState.Error("Failed to add person")
        val viewModel = AddPersonViewModel(mockPeopleRepository)
        val collectionList = mutableListOf<AddPersonUiState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.addPersonUiState.collect { collectionList.add(it) }
        }
        val person = Person(
            id = null,
            name = "Alaa",
            age = 37,
            jobTitle = "Senior Android Developer",
            gender = Gender.Male
        )
        coEvery { mockPeopleRepository.addPerson(person) } throws Exception()

        // When
        viewModel.updatePersonInputState {
            PersonInputState(
                "Alaa",
                "37",
                "Senior Android Developer",
                "Male"
            )
        }
        viewModel.addPerson()

        // Then
        advanceUntilIdle()
        val result = collectionList[1]
        assertEquals(expectedResult, result)
    }
}