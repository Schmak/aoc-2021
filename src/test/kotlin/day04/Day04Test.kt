package day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day04Test {
    @Test
    fun part1() {
        val actual = part1(lines)
        assertThat(actual).isEqualTo(4512)
    }

    companion object {
        private val lines = readFile("04", type = "test")
    }
}