package app.madar.alaamadarsoft.ui.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PersonInputState {
    var name by mutableStateOf("")
    var age by mutableIntStateOf(0)
    var jobTitle by mutableStateOf("")
    var gender by mutableStateOf("")

    var isValidAge by mutableStateOf(true)

    fun validateInputs() {
        isValidAge = age >= 18
    }
}