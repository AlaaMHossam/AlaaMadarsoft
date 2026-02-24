package app.madar.alaamadarsoft.ui.add_person

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.madar.alaamadarsoft.AppContainer
import app.madar.alaamadarsoft.ui.add_person.viewmodel.AddPersonViewModel
import app.madar.alaamadarsoft.ui.add_person.viewmodel.AddPersonViewModelFactory
import app.madar.alaamadarsoft.ui.states.AddPersonUiState

@Composable
fun AddPersonScreen(navigateToPeople: () -> Unit) {

    val container = LocalContext.current.applicationContext as AppContainer

    val factory = remember {
        AddPersonViewModelFactory(container.peopleRepository)
    }

    val addPersonViewModel: AddPersonViewModel = viewModel(factory = factory)

    val addPersonUiState by
    addPersonViewModel.addPersonUiState.collectAsStateWithLifecycle(AddPersonUiState.Initial)

    AddPersonContent(
        personInputState = addPersonViewModel.personInputState,
        updatePersonInputState = { addPersonViewModel.updatePersonInputState { it } },
        onSubmitClicked = { addPersonViewModel.addPerson() },
        onAllPeopleButtonClicked = navigateToPeople,
        addPersonUiState = addPersonUiState,
        onAddAnotherClicked = addPersonViewModel::resetAddPersonUiState,
        onTryAgainClicked = addPersonViewModel::resetAddPersonUiState
    )
}