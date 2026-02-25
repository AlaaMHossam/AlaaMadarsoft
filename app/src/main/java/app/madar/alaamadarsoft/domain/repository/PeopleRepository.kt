package app.madar.alaamadarsoft.domain.repository

import app.madar.alaamadarsoft.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    suspend fun addPerson(person: Person)
    fun getPeople(): Flow<List<Person>>
}