package app.madar.alaamadarsoft.data.data_source.db

import android.content.Context
import androidx.room.Room

class DBProvider(val context: Context) {

    private fun peopleDb() = Room.databaseBuilder(
        context = context,
        klass = RoomDatabase::class.java,
        name = "PeopleDB"
    ).build()

    val peopleDao = peopleDb().peopleDao()
}