package app.madar.alaamadarsoft.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.madar.alaamadarsoft.domain.model.Gender
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.states.AddPersonUiState
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PeopleViewModel(val peopleRepository: PeopleRepository) : ViewModel() {

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
            _addPersonUiState.emit(AddPersonUiState.Loading)
            runCatching {
                peopleRepository.addPerson(
                    Person(
                        id = 1,
                        name = "Alaa",
                        age = 37,
                        jobTitle = "Senior Android Developer",
                        gender = Gender.Male
                    )
                )
            }.onSuccess { _addPersonUiState.emit(AddPersonUiState.Success("Person Added")) }
        }
    }
}