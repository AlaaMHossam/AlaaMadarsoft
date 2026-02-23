package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.madar.alaamadarsoft.ui.states.PersonInputState

@Composable
fun AddPersonContent(
    personInputState: PersonInputState,
    updatePersonInputState: (PersonInputState) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Add a person", style = MaterialTheme.typography.titleLarge)

        TextField(
            value = personInputState.name,
            onValueChange = {
                updatePersonInputState(personInputState.copy(name = it))
            },
            placeholder = { Text("Name") },

            )
        TextField(
            value = "",
            onValueChange = {}
        )
        TextField(value = "", onValueChange = {})
        TextField(value = "", onValueChange = {})

        Button(onClick = {}) {
            Text("Add")
        }
    }
}

@Preview
@Composable
private fun AddPersonContentPreview() {
    AddPersonContent(PersonInputState(), {})
}