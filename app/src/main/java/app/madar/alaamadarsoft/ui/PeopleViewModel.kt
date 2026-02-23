package app.madar.alaamadarsoft.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.madar.alaamadarsoft.domain.model.Gender
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.states.AddPersonUiState
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import app.madar.alaamadarsoft.ui.states.PersonInputState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PeopleViewModel(val peopleRepository: PeopleRepository) : ViewModel() {

    var personInputState by mutableStateOf(PersonInputState())
        private set

    fun updatePersonInputState(transform: PersonInputState.() -> PersonInputState) {
        personInputState = personInputState.transform()
    }

    private val _peopleUiState = MutableStateFlow<PeopleUiState>(PeopleUiState.Initial)
    val peopleUiState = _peopleUiState.asStateFlow()

    private val _addPersonUiState = MutableSharedFlow<AddPersonUiState>()
    val addPersonUiState = _addPersonUiState.asSharedFlow()

    fun updatePeopleUiState() {
        viewModelScope.launch {
            _peopleUiState.update { PeopleUiState.Loading }
        }
    }

    fun addPerson() {
        viewModelScope.launch {
            if (personInputState.isValidInputs) {
                _addPersonUiState.emit(AddPersonUiState.Loading)

                val person = Person(
                    name = personInputState.name,
                    age = personInputState.age.toInt(),
                    jobTitle = personInputState.jobTitle,
                    gender = Gender.valueOf(personInputState.gender),
                )

                runCatching { peopleRepository.addPerson(person) }
                    .onSuccess { _addPersonUiState.emit(AddPersonUiState.Success("Person Added")) }
                    .onFailure { _addPersonUiState.emit(AddPersonUiState.Error("Failed to add person")) }
            }
        }
    }
}