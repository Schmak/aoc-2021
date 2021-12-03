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

    companion object {
        val input = readFile("03", type = "test")
    }
}