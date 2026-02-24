package app.madar.alaamadarsoft

import android.app.Application
import androidx.room.Room
import app.madar.alaamadarsoft.data.data_source.db.RoomDatabase
import app.madar.alaamadarsoft.data.repository.PeopleRepositoryImpl
import app.madar.alaamadarsoft.domain.repository.PeopleRepository

class TestApp : Application(), AppContainer {
    override val peopleRepository: PeopleRepository by lazy {
        val db = Room.inMemoryDatabaseBuilder(this, RoomDatabase::class.java).build()
        PeopleRepositoryImpl(db.peopleDao())
    }
}