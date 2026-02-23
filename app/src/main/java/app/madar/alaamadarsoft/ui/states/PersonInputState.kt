package app.madar.alaamadarsoft.ui.states

data class PersonInputState(
    val name: String = "",
    val age: String = "",
    val jobTitle: String = "",
    val gender: String = "",
) {
    val isValidAge: Boolean
        get() = age.toIntOrNull()?.let { it >= 18 } ?: false

    val isValidJobTitle: Boolean
        get() = jobTitle.isNotBlank()

    val isValidGender: Boolean
        get() = gender.isNotBlank()

    val isValidInputs: Boolean
        get() = isValidAge && isValidJobTitle && isValidGender
}