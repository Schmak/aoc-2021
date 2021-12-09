package day09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day09Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(15)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(1134)
    }

    companion object {
        private val input = parseInput(readFile("09", type = "test"))
    }
}