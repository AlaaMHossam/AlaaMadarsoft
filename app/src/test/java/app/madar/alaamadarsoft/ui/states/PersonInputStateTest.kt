package app.madar.alaamadarsoft.ui.states

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PersonInputStateTest {

    private lateinit var personInputState: PersonInputState

    @Before
    fun setUp() {
        personInputState = PersonInputState()
    }

    @Test
    fun when_age_is_less_than_18_then_isValid_age_is_false() {
        // Given
        val expectedResult = false

        // When
        personInputState.age = 1
        personInputState.validateInputs()

        // Then
        val result = personInputState.isValidAge
        assertEquals(expectedResult, result)
    }

    @Test
    fun when_job_title_is_blank_then_isValidJobTitle_is_false() {
        // Given
        val expectedResult = false

        // When
        personInputState.jobTitle = "  "
        personInputState.validateInputs()

        // Then
        val result = personInputState.isValidJobTitle
        assertEquals(expectedResult, result)
    }
}