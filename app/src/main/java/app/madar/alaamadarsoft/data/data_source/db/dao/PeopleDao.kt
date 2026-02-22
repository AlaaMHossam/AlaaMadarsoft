package app.madar.alaamadarsoft.data.data_source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import app.madar.alaamadarsoft.data.data_source.db.entities.PersonEntity

@Dao
interface PeopleDao {

    @Query("SELECT * FROM personentity")
    suspend fun getPeople(): List<PersonEntity>

    @Insert
    suspend fun addPerson(personEntity: PersonEntity)
}