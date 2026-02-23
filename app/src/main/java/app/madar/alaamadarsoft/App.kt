package app.madar.alaamadarsoft

import android.app.Application
import app.madar.alaamadarsoft.data.data_source.db.DBProvider
import app.madar.alaamadarsoft.data.repository.PeopleRepositoryImpl
import app.madar.alaamadarsoft.domain.repository.PeopleRepository

class App : Application() {

    lateinit var peopleRepository: PeopleRepository

    override fun onCreate() {
        super.onCreate()

        val db = DBProvider(this)
        peopleRepository = PeopleRepositoryImpl(db.peopleDao)
    }
}