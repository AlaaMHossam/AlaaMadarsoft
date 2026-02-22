package app.madar.alaamadarsoft.domain.model

data class Person(
    val id: Int,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: Gender
)