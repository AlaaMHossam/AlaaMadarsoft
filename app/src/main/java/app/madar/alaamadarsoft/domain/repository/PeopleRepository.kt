package app.madar.alaamadarsoft.domain.repository

import app.madar.alaamadarsoft.domain.model.Person

interface PeopleRepository {
    suspend fun addPerson(person: Person)
    suspend fun getPeople(): List<Person>
}