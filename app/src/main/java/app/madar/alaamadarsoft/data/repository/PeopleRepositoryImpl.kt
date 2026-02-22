package app.madar.alaamadarsoft.data.repository

import app.madar.alaamadarsoft.data.data_source.db.dao.PeopleDao
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.domain.repository.PeopleRepository

class PeopleRepositoryImpl(private val peopleDao: PeopleDao) : PeopleRepository {

    override suspend fun addPerson(person: Person) {
    }
}