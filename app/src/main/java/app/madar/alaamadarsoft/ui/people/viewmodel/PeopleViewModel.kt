package app.madar.alaamadarsoft.ui.people.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class PeopleViewModel(peopleRepository: PeopleRepository) : ViewModel() {

    val peopleUiState: StateFlow<PeopleUiState> = peopleRepository.getPeople()
        .map<List<Person>, PeopleUiState> { PeopleUiState.Success(it) }
        .onStart { emit(PeopleUiState.Loading) }
        .catch { emit(PeopleUiState.Error(it.message.orEmpty())) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = PeopleUiState.Initial
        )
}