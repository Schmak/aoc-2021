package day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day11Test {
    @Test
    fun part1() {
        val actual = part1(parseInput(input))
        assertThat(actual).isEqualTo(1656)
    }

    @Test
    fun part2() {
        val actual = part2(parseInput(input))
        assertThat(actual).isEqualTo(195)
    }

    companion object {
        private val input = readFile("11", type = "test")
    }
}