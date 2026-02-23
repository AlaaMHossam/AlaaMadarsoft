package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import app.madar.alaamadarsoft.ui.PeopleViewModel

@Composable
fun AddPersonScreen() {

    val peopleViewModel: PeopleViewModel = viewModel()

    AddPersonContent(
        personInputState = peopleViewModel.personInputState,
        updatePersonInputState = { peopleViewModel.updatePersonInputState { it } }
    ) {}
}