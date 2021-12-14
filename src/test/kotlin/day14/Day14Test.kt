package day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day14Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(1588)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(2188189693529)
    }

    companion object {
        private val input = Input.parse(readFile("14", type = "test"))
    }
}