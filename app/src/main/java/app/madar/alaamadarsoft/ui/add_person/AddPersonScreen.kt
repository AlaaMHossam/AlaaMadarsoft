package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.madar.alaamadarsoft.App
import app.madar.alaamadarsoft.ui.states.AddPersonUiState
import app.madar.alaamadarsoft.ui.viewmodel.PeopleViewModel
import app.madar.alaamadarsoft.ui.viewmodel.PeopleViewModelFactory

@Composable
fun AddPersonScreen(navigateToPeople: () -> Unit) {

    val app = LocalContext.current.applicationContext as App

    val factory = remember {
        PeopleViewModelFactory(app.peopleRepository)
    }

    val peopleViewModel: PeopleViewModel = viewModel(factory = factory)

    val addPersonUiState by
    peopleViewModel.addPersonUiState.collectAsStateWithLifecycle(AddPersonUiState.Initial)

    AddPersonContent(
        personInputState = peopleViewModel.personInputState,
        updatePersonInputState = { peopleViewModel.updatePersonInputState { it } },
        onSubmitClicked = { peopleViewModel.addPerson() },
        onAllPeopleButtonClicked = navigateToPeople,
        addPersonUiState = addPersonUiState,
        onAddAnotherClicked = peopleViewModel::resetAddPersonUiState,
        onTryAgainClicked = peopleViewModel::resetAddPersonUiState
    )
}