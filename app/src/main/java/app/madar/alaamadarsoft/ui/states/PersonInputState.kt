package app.madar.alaamadarsoft.ui.states

data class PersonInputState(
    val name: String = "",
    val age: Int = 0,
    val jobTitle: String = "",
    val gender: String = "",
) {
    val isValidAge: Boolean
        get() = age >= 18

    val isValidJobTitle: Boolean
        get() = jobTitle.isNotBlank()

    val isValidGender: Boolean
        get() = gender.isNotBlank()

    val isValidInputs: Boolean
        get() = isValidAge && isValidJobTitle && isValidGender
}