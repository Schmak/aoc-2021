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

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(3351)
    }

    companion object {
        private val input = parseInput(readFile("20", type = "test"))
    }
}