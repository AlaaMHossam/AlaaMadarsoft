package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import app.madar.alaamadarsoft.App
import app.madar.alaamadarsoft.ui.PeopleViewModel
import app.madar.alaamadarsoft.ui.PeopleViewModelFactory

@Composable
fun AddPersonScreen(modifier: Modifier) {

    val app = LocalContext.current.applicationContext as App

    val factory = remember {
        PeopleViewModelFactory(app.peopleRepository)
    }

    val peopleViewModel: PeopleViewModel = viewModel(factory = factory)

    AddPersonContent(
        modifier = modifier,
        personInputState = peopleViewModel.personInputState,
        updatePersonInputState = { peopleViewModel.updatePersonInputState { it } },
        onSubmitClicked = { peopleViewModel.addPerson() }
    )
}