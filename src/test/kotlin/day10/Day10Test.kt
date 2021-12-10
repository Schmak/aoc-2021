package day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day10Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(26397)
    }

    companion object {
        private val input = parseInput(readFile("10", type = "test"))
    }
}