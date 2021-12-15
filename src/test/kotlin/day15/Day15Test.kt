package day15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day15Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(40)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(315)
    }

    companion object {
        private val input = parseInput(readFile("15", type = "test"))
    }
}