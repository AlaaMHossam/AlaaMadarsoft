package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import app.madar.alaamadarsoft.R
import app.madar.alaamadarsoft.ui.GenderTextField
import app.madar.alaamadarsoft.ui.states.PersonInputState

@Composable
fun AddPersonContent(
    modifier: Modifier = Modifier,
    personInputState: PersonInputState,
    updatePersonInputState: (PersonInputState) -> Unit,
    onSubmitClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            stringResource(R.string.add_a_person_title),
            style = MaterialTheme.typography.titleLarge
        )

        TextField(
            value = personInputState.name,
            onValueChange = { updatePersonInputState(personInputState.copy(name = it)) },
            placeholder = { Text(stringResource(R.string.name)) },
            isError = personInputState.nameError,
            supportingText = {
                if (personInputState.nameError)
                    Text(stringResource(R.string.name_field_error_message))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        TextField(
            value = personInputState.age,
            onValueChange = {
                if (it.isDigitsOnly())
                    updatePersonInputState(personInputState.copy(age = it))
            },
            placeholder = { Text(stringResource(R.string.age)) },
            isError = personInputState.ageError,
            supportingText = {
                if (personInputState.ageError)
                    Text(stringResource(R.string.age_field_error_message))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = personInputState.jobTitle,
            onValueChange = { updatePersonInputState(personInputState.copy(jobTitle = it)) },
            placeholder = { Text(stringResource(R.string.job_title)) },
            isError = personInputState.jobTitleError,
            supportingText = {
                if (personInputState.jobTitleError)
                    Text(stringResource(R.string.job_title_field_error_message))
            },
            singleLine = true
        )

        GenderTextField(
            gender = personInputState.gender,
            onGenderChange = { updatePersonInputState(personInputState.copy(gender = it)) },
            isValidGender = !personInputState.genderError
        )

        Button(onClick = onSubmitClicked) { Text(stringResource(R.string.add_button_text)) }
    }
}

@Preview
@Composable
private fun AddPersonContentPreview() {
    AddPersonContent(modifier = Modifier, PersonInputState(), {}) {}
}