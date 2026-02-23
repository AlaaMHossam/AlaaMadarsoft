package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import app.madar.alaamadarsoft.ui.PeopleViewModel

@Composable
fun AddPersonScreen(modifier: Modifier) {

    val peopleViewModel: PeopleViewModel = viewModel()

    AddPersonContent(
        modifier = modifier,
        personInputState = peopleViewModel.personInputState,
        updatePersonInputState = { peopleViewModel.updatePersonInputState { it } },
        onSubmitClicked = { peopleViewModel.addPerson() }
    )
}