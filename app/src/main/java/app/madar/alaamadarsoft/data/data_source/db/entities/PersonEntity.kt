package app.madar.alaamadarsoft.data.data_source.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.madar.alaamadarsoft.domain.model.Gender

@Entity
data class PersonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: Gender
)