package day03

import day03.Day03Test.Companion.input
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    @Test
    fun gamma() {
        assertThat(calculator.gamma).isEqualTo(22)
    }

    @Test
    fun epsilon() {
        assertThat(calculator.epsilon).isEqualTo(9)
    }

    @Test
    fun oxygen() {
        assertThat(calculator.oxygen).isEqualTo(23)
    }

    @Test
    fun co2() {
        assertThat(calculator.co2).isEqualTo(10)
    }

    companion object {
        private val calculator = Calculator(input)
    }
}