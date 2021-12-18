package day17

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day17Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(45)
    }

    companion object {
        private val input = parseInput(readFile("17", type = "test"))
    }
}