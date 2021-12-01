package day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day01Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(7)
    }

    companion object {
        private val input = parseInput(readFile("01", type = "test"))
    }
}