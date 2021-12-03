package day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day03Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(198)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(230)
    }

    companion object {
        val input = readFile("03", type = "test")
    }
}