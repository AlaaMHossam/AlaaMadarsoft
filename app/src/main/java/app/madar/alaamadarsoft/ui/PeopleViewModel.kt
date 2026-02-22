package app.madar.alaamadarsoft.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.madar.alaamadarsoft.ui.states.PeopleUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {

    private val _peopleUiState = MutableStateFlow<PeopleUiState>(PeopleUiState.Initial)
    val peopleUiState = _peopleUiState.asStateFlow()

    fun updatePeopleUiState() {
        viewModelScope.launch {
            _peopleUiState.update { PeopleUiState.Loading }
        }
    }
}