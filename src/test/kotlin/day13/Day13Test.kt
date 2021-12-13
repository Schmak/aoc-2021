package day13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day13Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(17)
    }

    companion object {
        private val input = Input.parse(readFile("13", type = "test"))
    }
}