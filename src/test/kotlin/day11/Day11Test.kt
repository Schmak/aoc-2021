package day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day11Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(1656)
    }

    companion object {
        private val input = parseInput(readFile("11", type = "test"))
    }
}