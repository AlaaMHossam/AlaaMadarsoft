package app.madar.alaamadarsoft.data.mappers

import app.madar.alaamadarsoft.data.data_source.db.entities.PersonEntity
import app.madar.alaamadarsoft.domain.model.Person

fun Person.toEntity(): PersonEntity =
    PersonEntity(
        id = id ?: 0,
        name = name,
        age = age,
        jobTitle = jobTitle,
        gender = gender
    )

fun PersonEntity.toPerson(): Person =
    Person(
        id = id,
        name = name,
        age = age,
        jobTitle = jobTitle,
        gender = gender
    )

fun List<PersonEntity>.toPeople() : List<Person> = map { it.toPerson() }