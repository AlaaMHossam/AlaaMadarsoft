package app.madar.alaamadarsoft.data.data_source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import app.madar.alaamadarsoft.data.data_source.db.entities.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PeopleDao {

    @Query("SELECT * FROM personentity")
    fun getPeople(): Flow<List<PersonEntity>>

    @Insert
    suspend fun addPerson(personEntity: PersonEntity)
}