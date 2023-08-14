package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    // An example of Instrumentation testing
    // here we create an instance of the app and its UI
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        // with composeTestRule we can access UI components
        // as nodes, here we access the one for the bill amount
        composeTestRule
            .onNodeWithText("Bill Amount")
            .performTextInput("10")

        // now the percentage
        composeTestRule
            .onNodeWithText("Tip Percentage")
            .performTextInput("20")

        // the same as with the local test, we end with an assertion
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule
            .onNodeWithText("Tip Amount: $expectedTip")
            // if it does not exists then this message is displayed
            .assertExists("No node with this text was found.")

    }

}