package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test

    // An example of local testing
    fun calculateTip_20PercentNoRoundup() {

        val amount = 10.00
        val tipPercent = 20.00

        // the expected result, same type as returned by calculateTip()
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // real value obtained from the tested function
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)

        // we check if the values coincide with an assertion
        // this is typically the end goal of automated testing
        assertEquals(expectedTip, actualTip)
    }
}
