package app.madar.alaamadarsoft.ui.states

import org.junit.Assert.assertEquals
import org.junit.Test

class PersonInputStateTest {

    @Test
    fun when_age_is_less_than_18_then_isValidAge_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(age = 1)

        // When

        // Then
        val result = personInputState.isValidAge
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_jobTitle_is_blank_then_isValidJobTitle_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(jobTitle = "   ")

        // When

        // Then
        val result = personInputState.isValidJobTitle
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_gender_is_empty_then_isValidGender_is_false() {
        // Given
        val expectedResult = false
        val personInputState = PersonInputState(gender = "")

        // When

        // Then
        val result = personInputState.isValidGender
        assertEquals(expectedResult, result)
    }
}