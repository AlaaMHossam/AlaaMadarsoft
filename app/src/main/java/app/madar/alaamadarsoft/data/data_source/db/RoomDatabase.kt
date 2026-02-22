package app.madar.alaamadarsoft.data.data_source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import app.madar.alaamadarsoft.data.data_source.db.dao.PeopleDao
import app.madar.alaamadarsoft.data.data_source.db.entities.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}