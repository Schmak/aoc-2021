package day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day02Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(150)
    }

    companion object {
        private val input = parseInput(readFile("02", type = "test"))
    }
}