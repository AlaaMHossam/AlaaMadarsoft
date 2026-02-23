package app.madar.alaamadarsoft.ui.people

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.madar.alaamadarsoft.ui.states.PeopleUiState

@Composable
fun PeopleContent(peopleUiState: PeopleUiState) {
    Box(modifier = Modifier.fillMaxSize()) {

        when (peopleUiState) {
            PeopleUiState.Initial -> {/* no-op */
            }

            PeopleUiState.Loading -> {
                CircularProgressIndicator()
            }

            is PeopleUiState.Success -> {}
        }
    }
}

@Preview
@Composable
private fun PeopleContentPreview() {
    PeopleContent(peopleUiState = PeopleUiState.Initial)
}