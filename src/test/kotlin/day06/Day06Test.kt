package day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day06Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(5934)
    }

    companion object {
        private val input = parseInput(readFile("06", type = "test"))
    }
}