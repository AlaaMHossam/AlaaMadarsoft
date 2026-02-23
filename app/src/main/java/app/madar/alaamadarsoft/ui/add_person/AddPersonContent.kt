package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.madar.alaamadarsoft.R
import app.madar.alaamadarsoft.ui.ADD_BUTTON_TEST_TAG
import app.madar.alaamadarsoft.ui.PEOPLE_BUTTON_TEST_TAG
import app.madar.alaamadarsoft.ui.states.AddPersonUiState
import app.madar.alaamadarsoft.ui.states.PersonInputState

@Composable
fun AddPersonContent(
    modifier: Modifier = Modifier,
    personInputState: PersonInputState,
    updatePersonInputState: (PersonInputState) -> Unit,
    onSubmitClicked: () -> Unit,
    onAllPeopleButtonClicked: () -> Unit,
    addPersonUiState: AddPersonUiState,
    onAddAnotherClicked: () -> Unit,
    onTryAgainClicked: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        when (addPersonUiState) {
            AddPersonUiState.Initial -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Text(
                        text = stringResource(R.string.add_a_person_title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    TextFields(personInputState, updatePersonInputState)
                    Button(
                        modifier = Modifier.testTag(ADD_BUTTON_TEST_TAG),
                        onClick = onSubmitClicked
                    ) { Text(stringResource(R.string.add_button_text)) }
                }
            }

            AddPersonUiState.Loading -> {
                CircularProgressIndicator()
            }

            is AddPersonUiState.Error -> {
                Column {
                    Text(text = addPersonUiState.errorMessage)
                    Button(onClick = onTryAgainClicked) { Text("Try again") }
                }
            }

            is AddPersonUiState.Success -> {
                Column {
                    Image(
                        painterResource(android.R.drawable.checkbox_on_background),
                        contentDescription = null
                    )
                    Button(onClick = onAddAnotherClicked) { Text("Add another") }
                }
            }
        }

        Button(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .testTag(PEOPLE_BUTTON_TEST_TAG),
            onClick = onAllPeopleButtonClicked
        ) {
            Text(stringResource(R.string.all_people_button_text))
        }
    }
}

@Preview
@Composable
private fun AddPersonContentPreview() {
    AddPersonContent(
        modifier = Modifier,
        personInputState = PersonInputState(),
        updatePersonInputState = {},
        onSubmitClicked = {},
        onAllPeopleButtonClicked = {},
        addPersonUiState = AddPersonUiState.Initial,
        onAddAnotherClicked = {},
        onTryAgainClicked = {}
    )
}