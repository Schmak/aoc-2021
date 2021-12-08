package day08

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day08Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(26)
    }

    companion object {
        private val input = readFile("08", type = "test")
    }
}