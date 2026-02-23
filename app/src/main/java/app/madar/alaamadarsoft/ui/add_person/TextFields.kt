package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import app.madar.alaamadarsoft.R
import app.madar.alaamadarsoft.ui.AGE_FIELD_TEST_TAG
import app.madar.alaamadarsoft.ui.GenderTextField
import app.madar.alaamadarsoft.ui.JOB_TITLE_FIELD_TEST_TAG
import app.madar.alaamadarsoft.ui.NAME_FIELD_TEST_TAG
import app.madar.alaamadarsoft.ui.states.PersonInputState

@Composable
fun TextFields(
    personInputState: PersonInputState,
    updatePersonInputState: (PersonInputState) -> Unit
) {
    Column {
        TextField(
            modifier = Modifier.testTag(NAME_FIELD_TEST_TAG),
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
            modifier = Modifier.testTag(AGE_FIELD_TEST_TAG),
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
            modifier = Modifier.testTag(JOB_TITLE_FIELD_TEST_TAG),
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
    }
}

