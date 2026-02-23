package app.madar.alaamadarsoft.domain.model

data class Person(
    val id: Int? = null,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: Gender
)