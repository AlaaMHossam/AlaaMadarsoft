package app.madar.alaamadarsoft.ui.states

sealed class AddPersonUiState {
    object Loading : AddPersonUiState()
    data class Success(val message: String) : AddPersonUiState()
    data class Error(val errorMessage: String) : AddPersonUiState()
}