package app.madar.alaamadarsoft.ui.states

import org.junit.Assert.assertEquals
import org.junit.Test

class PersonInputStateTest {

    @Test
    fun when_name_is_empty_then_isValidName_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(name = "   ")

        // When

        // Then
        val result = personInputState.nameError
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_age_is_less_than_18_then_isValidAge_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(age = "1")

        // When

        // Then
        val result = personInputState.ageError
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_jobTitle_is_blank_then_isValidJobTitle_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(jobTitle = "   ")

        // When

        // Then
        val result = personInputState.jobTitleError
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_gender_is_empty_then_isValidGender_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(gender = "")

        // When

        // Then
        val result = personInputState.genderError
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_valid_inputs_then_isValidInputs_is_true() {
        // Given
        val expectedResult = true
        val personInputState = PersonInputState(
            name = "Alaa",
            age = "20",
            gender = "Male",
            jobTitle = "Senior Android Developer",
            isSubmitted = true
        )

        // When

        // Then
        val result = personInputState.isValidInputs
        assertEquals(expectedResult, result)
    }
}