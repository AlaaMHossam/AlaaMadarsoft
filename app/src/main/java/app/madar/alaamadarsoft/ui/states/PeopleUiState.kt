package app.madar.alaamadarsoft.ui.states

// This can be a sealed class or interface
sealed interface PeopleUiState {
    object Initial : PeopleUiState
    object Loading : PeopleUiState
}