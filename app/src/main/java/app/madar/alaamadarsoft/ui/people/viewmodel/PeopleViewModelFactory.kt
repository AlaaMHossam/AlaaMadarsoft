package app.madar.alaamadarsoft.ui.people.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.madar.alaamadarsoft.domain.repository.PeopleRepository

class PeopleViewModelFactory(private val peopleRepository: PeopleRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PeopleViewModel(peopleRepository) as T
    }
}