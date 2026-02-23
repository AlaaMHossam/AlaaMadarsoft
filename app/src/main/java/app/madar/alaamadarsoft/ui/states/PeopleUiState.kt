package app.madar.alaamadarsoft.ui.states

import app.madar.alaamadarsoft.domain.model.Person

// This can be a sealed class or interface
sealed interface PeopleUiState {
    object Initial : PeopleUiState
    object Loading : PeopleUiState
    data class Success(val people: List<Person>) : PeopleUiState
}