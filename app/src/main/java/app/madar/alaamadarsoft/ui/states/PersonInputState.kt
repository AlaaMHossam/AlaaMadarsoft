package app.madar.alaamadarsoft.ui.states

data class PersonInputState(
    val name: String = "",
    val age: String = "",
    val jobTitle: String = "",
    val gender: String = "",
    val isSubmitted: Boolean = false
) {
    private val isValidName: Boolean
        get() = name.isNotBlank()

    private val isValidAge: Boolean
        get() = age.toIntOrNull()?.let { it >= 18 } ?: false

    private val isValidJobTitle: Boolean
        get() = jobTitle.isNotBlank()

    private val isValidGender: Boolean
        get() = gender.isNotBlank()

    val nameError: Boolean
        get() = isSubmitted && !isValidName

    val ageError: Boolean
        get() = isSubmitted && !isValidAge

    val jobTitleError: Boolean
        get() = isSubmitted && !isValidJobTitle

    val genderError: Boolean
        get() = isSubmitted && !isValidGender

    val isValidInputs: Boolean
        get() = isValidAge && isValidJobTitle && isValidGender
}