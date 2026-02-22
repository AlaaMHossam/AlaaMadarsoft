package app.madar.alaamadarsoft.data.repository

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import app.madar.alaamadarsoft.data.data_source.db.RoomDatabase
import app.madar.alaamadarsoft.data.data_source.db.dao.PeopleDao
import app.madar.alaamadarsoft.data.data_source.db.entities.PersonEntity
import app.madar.alaamadarsoft.domain.model.Gender
import app.madar.alaamadarsoft.domain.model.Person
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PeopleRepositoryImplTest {

    private lateinit var peopleRepositoryImpl: PeopleRepositoryImpl
    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private lateinit var peopleDao: PeopleDao

    @Before
    fun setUp() {
        val inMemoryDb = Room.inMemoryDatabaseBuilder(context, RoomDatabase::class.java).build()
        peopleDao = inMemoryDb.peopleDao()
        peopleRepositoryImpl = PeopleRepositoryImpl(peopleDao)
    }

    @Test
    fun when_add_person_then_person_is_saved_in_db() {
        // Given
        val expectedResult = PersonEntity(
            id = 1,
            name = "Alaa",
            age = 37,
            jobTitle = "Senior Android Developer",
            gender = Gender.Male
        )
        val person = Person(
            id = 1,
            name = "Alaa",
            age = 37,
            jobTitle = "Senior Android Developer",
            gender = Gender.Male
        )

        // When
        runBlocking { peopleRepositoryImpl.addPerson(person) }

        // Then
        val result = runBlocking { peopleDao.getPeople().first() }
        assertEquals(expectedResult, result)
    }
}