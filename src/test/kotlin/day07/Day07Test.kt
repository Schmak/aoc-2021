package day07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day07Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(37)
    }

    companion object {
        private val input = parseInput(readFile("07", type = "test"))
    }
}