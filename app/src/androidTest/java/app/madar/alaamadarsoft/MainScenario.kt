package app.madar.alaamadarsoft

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import app.madar.alaamadarsoft.ui.AGE_FIELD_TEST_TAG
import app.madar.alaamadarsoft.ui.DISPLAY_BUTTON_TEST_TAG
import app.madar.alaamadarsoft.ui.GENDER_FIELD_TEST_TAG
import app.madar.alaamadarsoft.ui.JOB_TITLE_FIELD_TEST_TAG
import app.madar.alaamadarsoft.ui.NAME_FIELD_TEST_TAG
import org.junit.Rule
import org.junit.Test

class MainScenario {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun when_user_inputs_data_then_data_is_displayed() {
        // Given
        val name = "Alaa"
        val age = 37
        val jobTitle = "Senior Android Developer"

        // When
        composeTestRule.onNodeWithTag(NAME_FIELD_TEST_TAG).performTextInput(name)
        composeTestRule.onNodeWithTag(AGE_FIELD_TEST_TAG).performTextInput(age.toString())
        composeTestRule.onNodeWithTag(JOB_TITLE_FIELD_TEST_TAG).performTextInput(jobTitle)
        composeTestRule.onNodeWithTag(GENDER_FIELD_TEST_TAG).performClick()
        composeTestRule.onNodeWithText("Male").performClick()
        composeTestRule.onNodeWithTag(DISPLAY_BUTTON_TEST_TAG).performClick()

        // Then
        composeTestRule.onNodeWithText(name).assertIsDisplayed()
    }
}