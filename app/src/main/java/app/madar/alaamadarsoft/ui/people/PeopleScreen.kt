package app.madar.alaamadarsoft.ui.people

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import app.madar.alaamadarsoft.App
import app.madar.alaamadarsoft.ui.viewmodel.PeopleViewModel
import app.madar.alaamadarsoft.ui.viewmodel.PeopleViewModelFactory

@Composable
fun PeopleScreen() {

    val app = LocalContext.current.applicationContext as App

    val factory = remember {
        PeopleViewModelFactory(app.peopleRepository)
    }

    val peopleViewModel: PeopleViewModel = viewModel(factory = factory)

    val peopleUiState by peopleViewModel.peopleUiState.collectAsStateWithLifecycle()

    PeopleContent(
        peopleUiState = peopleUiState
    )
}