package app.madar.alaamadarsoft.ui.people.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PeopleViewModel(val peopleRepository: PeopleRepository) : ViewModel() {

    private val _peopleUiState = MutableStateFlow<PeopleUiState>(PeopleUiState.Initial)
    val peopleUiState = _peopleUiState.asStateFlow()

    fun updatePeopleUiState() {
        viewModelScope.launch {
            _peopleUiState.update { PeopleUiState.Loading }
            runCatching { peopleRepository.getPeople() }
                .onSuccess { people -> _peopleUiState.update { PeopleUiState.Success(people) } }
                .onFailure { exception ->
                    _peopleUiState.update { PeopleUiState.Error(exception.message.orEmpty()) }
                }
        }
    }


}