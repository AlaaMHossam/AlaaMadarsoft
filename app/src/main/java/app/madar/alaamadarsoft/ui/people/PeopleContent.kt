package app.madar.alaamadarsoft.ui.people

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.madar.alaamadarsoft.R
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.ui.states.PeopleUiState

@Composable
fun PeopleContent(peopleUiState: PeopleUiState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        when (peopleUiState) {
            PeopleUiState.Initial -> {/* no-op */
            }

            PeopleUiState.Loading -> {
                CircularProgressIndicator()
            }

            is PeopleUiState.Success -> {
                Column {
                    Text(
                        text = stringResource(R.string.people_title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(42.dp))
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        items(
                            count = peopleUiState.people.size,
                            key = { it },
                            contentType = { Person::class },
                            itemContent = { PersonCard(peopleUiState.people[it]) }
                        )
                    }
                }
            }

            is PeopleUiState.Error -> {
                Text(text = peopleUiState.message)
            }
        }
    }
}

@Composable
private fun PersonCard(person: Person) {
    Card(modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "${stringResource(R.string.name)}: ${person.name}")
            Text(text = "${stringResource(R.string.age)}: ${person.age}")
            Text(text = "${stringResource(R.string.job_title)}: ${person.jobTitle}")
            Text(text = "${stringResource(R.string.gender)}: ${person.gender.value}")
        }
    }
}

@Preview
@Composable
private fun PeopleContentPreview() {
    PeopleContent(peopleUiState = PeopleUiState.Initial)
}