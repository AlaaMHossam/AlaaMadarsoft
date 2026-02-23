package app.madar.alaamadarsoft.ui.add_person.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.madar.alaamadarsoft.domain.repository.PeopleRepository

class AddPersonViewModelFactory(private val peopleRepository: PeopleRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddPersonViewModel(peopleRepository) as T
    }
}