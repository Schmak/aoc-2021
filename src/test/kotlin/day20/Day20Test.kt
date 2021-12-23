package day20

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day20Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(35)
    }

    companion object {
        private val input = parseInput(readFile("20", type = "test"))
    }
}