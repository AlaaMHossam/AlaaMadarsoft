package app.madar.alaamadarsoft

import app.madar.alaamadarsoft.domain.repository.PeopleRepository

interface AppContainer {
    val peopleRepository: PeopleRepository
}