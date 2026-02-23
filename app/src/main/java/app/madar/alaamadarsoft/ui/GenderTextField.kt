package app.madar.alaamadarsoft.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import app.madar.alaamadarsoft.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderTextField(
    modifier: Modifier = Modifier,
    gender: String,
    onGenderChange: (String) -> Unit,
    isValidGender: Boolean
) {
    var isMenuExpandedState by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    Column {
        BasicTextField(
            value = gender,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            interactionSource = interactionSource,
            modifier = modifier,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            decorationBox = { innerTextField ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = gender,
                    innerTextField = innerTextField,
                    enabled = true,
                    isError = !isValidGender,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = OutlinedTextFieldDefaults.contentPadding(),
                    placeholder = { Text(text = stringResource(R.string.gender)) },
                    supportingText = {
                        if (!isValidGender) {
                            Text(stringResource(R.string.gender_field_error_message))
                        }
                    },
                    container = {
                        OutlinedTextFieldDefaults.Container(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = { isMenuExpandedState = true }),
                            enabled = true,
                            isError = !isValidGender,
                            interactionSource = interactionSource
                        )
                    }
                )
            }
        )
        DropDownMenu(
            isMenuExpanded = isMenuExpandedState,
            onGenderChange = onGenderChange,
            onDismissRequest = { isMenuExpandedState = false })
    }
}

@Composable
private fun DropDownMenu(
    isMenuExpanded: Boolean,
    onGenderChange: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
    DropdownMenu(
        modifier = Modifier,
        expanded = isMenuExpanded,
        onDismissRequest = { onDismissRequest() }
    ) {
        DropdownMenuItem(
            text = { Text("Male") },
            onClick = {
                onGenderChange("Male")
                onDismissRequest()
            }
        )
        DropdownMenuItem(
            text = { Text("Female") },
            onClick = {
                onGenderChange("Female")
                onDismissRequest()
            }
        )
    }
}