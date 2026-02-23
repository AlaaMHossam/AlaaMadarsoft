package app.madar.alaamadarsoft.data.repository

import app.madar.alaamadarsoft.data.data_source.db.dao.PeopleDao
import app.madar.alaamadarsoft.data.mappers.toEntity
import app.madar.alaamadarsoft.data.mappers.toPeople
import app.madar.alaamadarsoft.domain.model.Person
import app.madar.alaamadarsoft.domain.repository.PeopleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeopleRepositoryImpl(private val peopleDao: PeopleDao) : PeopleRepository {

    override suspend fun addPerson(person: Person) = withContext(Dispatchers.IO) {
        peopleDao.addPerson(person.toEntity())
    }

    override suspend fun getPeople(): List<Person> = withContext(Dispatchers.IO) {
        peopleDao.getPeople().toPeople()
    }
}